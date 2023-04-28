package com.example.detroyfitness2;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class Nutricion_alimentos extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference alimentosRef = db.collection("alimentos");
    ArrayList<Alimentos> listaAlimentos = new ArrayList<>();
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("alimentos");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutricion_alimentos);

        RecyclerView lista = findViewById(R.id.container_main);


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Alimentos> listaAlimentos = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String nombre = snapshot.child("nombre").getValue(String.class);
                    String kcal = snapshot.child("kcal").getValue(String.class);
                    String proteina = snapshot.child("proteina").getValue(String.class);
                    String grasas = snapshot.child("grasas").getValue(String.class);
                    String carbohidratos = snapshot.child("carbohidratos").getValue(String.class);

                    Alimentos alimento = new Alimentos(nombre,carbohidratos,grasas, kcal, proteina);
                    listaAlimentos.add(alimento);
                }

                MiAdaptadorPersonalizado adaptador = new MiAdaptadorPersonalizado(listaAlimentos);
                lista.setAdapter(adaptador);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException());
            }
        });


    }

}

