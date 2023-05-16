package com.example.detroyfitness2;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Entrenamiento_desafio extends AppCompatActivity {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    // Obtén la fecha actual
    Calendar cal = Calendar.getInstance();
    // Obtén la semana actual
    int semanaActual = cal.get(Calendar.WEEK_OF_MONTH);

    //Variables
    TextView numero ;
    TextView nombre ;
    TextView reto1 ;
    TextView reto2 ;
    TextView reto3 ;
    TextView reto4 ;
    Array desafio1 ;
    RecyclerView texto_desafios ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrenamiento_desafio);

        //Botones Header
        ImageButton boton_atras = findViewById(R.id.B_flecha_atras_entrenamiento);

        //botones declarados toolbar
        Button botontoolbar_perfil = findViewById(R.id.B_perfil);
        Button botontoolbar_entrenamiento = findViewById(R.id.B_entrenamiento);
        Button botontoolbar_nutricion = findViewById(R.id.B_nutricion);


        actualizar_semana();


        //ejecucion de los botones
        //ejecucion de los botones
        botontoolbar_perfil.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de perfil
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_desafio.this, Perfil.class);
                startActivity(intent);
            }
        });

        botontoolbar_nutricion.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de nutricion
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_desafio.this, Nutricion.class);
                startActivity(intent);
            }
        });

        botontoolbar_entrenamiento.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de entrenamiento
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_desafio.this, Entrenamiento.class);
                startActivity(intent);
            }
        });

        boton_atras.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de atras
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_desafio.this, Entrenamiento.class);
                startActivity(intent);
            }
        });
}

    public void actualizar_semana() {
        switch(semanaActual) {
            case 1:
                // Mostrar datos de la primera semana
                mostrar_reto1("reto1");
                break;
            case 2:
                // Mostrar datos de la segunda semana
                mostrar_reto1("reto2");
                break;
            case 3:
                // Mostrar datos de la tercera semana
                mostrar_reto1("reto3");
                break;
            case 4:
                // Mostrar datos de la tercera semana
                mostrar_reto1("reto4");
                break;
            default:
                // Mostrar datos por defecto
                System.out.println(semanaActual);
                break;
        }
    }

    public void mostrar_reto1(String reto_semanal){
        //textview declarado
        numero = findViewById(R.id.texto_numero);
        nombre = findViewById(R.id.texto_nombre);
        reto1 = findViewById(R.id.texto_desafio1);
        reto2 = findViewById(R.id.texto_desafio2);
        reto3 = findViewById(R.id.texto_desafio3);
        reto4 = findViewById(R.id.texto_desafio4);
        DocumentReference docRef = db.collection("retos").document(reto_semanal);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    String reto_numero= documentSnapshot.getString("numero"); // Almacenamos el username en el array
                    String reto_nombre= documentSnapshot.getString("nombre"); // Almacenamos el username en el array
                    String reto_1= documentSnapshot.getString("ejercicio1"); // Almacenamos el username en el array
                    String reto_2= documentSnapshot.getString("ejercicio2"); // Almacenamos el username en el array
                    String reto_3= documentSnapshot.getString("ejercicio3"); // Almacenamos el username en el array
                    String reto_4= documentSnapshot.getString("ejercicio4"); // Almacenamos el username en el array
                    numero.setText(reto_numero);
                    nombre.setText(reto_nombre);
                    reto1.setText(reto_1);
                    reto2.setText(reto_2);
                    reto3.setText(reto_3);
                    reto4.setText(reto_4);


                } else {
                    Log.d(TAG, "No such document");
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "Error getting document: " + e.getMessage());
            }
        });

    }
}