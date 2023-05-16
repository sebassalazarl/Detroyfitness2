package com.example.detroyfitness2;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Nutricion_plansemanal extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String username1 ;
    Map<String, Object> data = new HashMap<>();
    ArrayList<dieta> listaSemanal = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutricion_plansemanal);


      ComprobarDieta();


        //botones declarados
        Button botontoolbar_perfil = findViewById(R.id.B_perfil);
        Button botontoolbar_entrenamiento = findViewById(R.id.B_entrenamiento);
        Button botontoolbar_nutricion = findViewById(R.id.B_nutricion);
        ImageButton btnAtras = findViewById(R.id.B_flecha_atras);


      RellenarListaDieta();

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nutricion_plansemanal.this, Nutricion.class);
                startActivity(intent);
            }
        });

        //ejecucion de los botones
        botontoolbar_perfil.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de perfil
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nutricion_plansemanal.this, Perfil.class);
                startActivity(intent);
            }
        });

        botontoolbar_nutricion.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de nutricion
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nutricion_plansemanal.this, Nutricion.class);
                startActivity(intent);
            }
        });

        botontoolbar_entrenamiento.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de entrenamiento
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nutricion_plansemanal.this, Entrenamiento.class);
                startActivity(intent);
            }
        });


    }

    public void ComprobarDieta(){


        DocumentReference docRef = db.collection("usuarios").document(user.getEmail());
        boolean bdieta ;
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot ) {
                if (documentSnapshot.exists() && documentSnapshot.contains("IDdieta")) {
                    // El campo "IDdieta" existe en el documento del usuario


                } else {
                    // El campo "IDdieta" no existe en el documento del usuario
                    DocumentReference docRef = db.collection("usuarios").document(user.getEmail());
                    docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                double TMB = documentSnapshot.getDouble("tmb");// Almacenamos el username en el array
                                String comidas = documentSnapshot.getString("NumComidas");
                                String PrefNutr = documentSnapshot.getString("PrefNutr");
                                asignarDieta(TMB, comidas, PrefNutr);
                            } else {
                                Log.d(TAG, "No such document");
                            }
                        }
                    });
                }
            }
        });
        }

    public void asignarDieta(double TMB,String comidas, String PrefNutr){

        // Obtener la referencia a la colección "dietas" en Firebase
        CollectionReference dietasRef = FirebaseFirestore.getInstance().collection("dietas");

        // Realizar una consulta para buscar los documentos donde "kcal" es igual a 1000
        Query query = dietasRef.whereGreaterThanOrEqualTo("kcal", TMB).whereLessThanOrEqualTo("kcal", TMB+500).whereEqualTo("NumComidas", comidas).whereEqualTo("PrefNutr", PrefNutr);

        // Ejecutar la consulta
        query.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // Recorrer los resultados de la consulta
                for (QueryDocumentSnapshot document : task.getResult()) {
                    //ID del documento encontrado
                    String dietaAsignar = document.getId();
                    data.put("IDdieta", dietaAsignar);
                    db.collection("usuarios").document(user.getEmail().toString()).update(data);
                }
            } else {
                // Si la consulta falla, imprimir el mensaje de error
                System.out.println("Error al realizar la consulta: " + task.getException());
            }
        });
    }
    public String sDieta_Asignada;
    public void RellenarListaDieta(){

        DocumentReference docRef = db.collection("usuarios").document(user.getEmail());
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                  sDieta_Asignada= documentSnapshot.getString("IDdieta"); // Almacenamos el dieta en el array
                    RecyclerView container_dietas = findViewById(R.id.container_dieta);
                    container_dietas.setLayoutManager(new LinearLayoutManager(Nutricion_plansemanal.this));
                    Adaptador_dietas adapter = new Adaptador_dietas(listaSemanal, sDieta_Asignada);
                    container_dietas.setAdapter(adapter);

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
