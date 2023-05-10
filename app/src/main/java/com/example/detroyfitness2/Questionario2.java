package com.example.detroyfitness2;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Questionario2 extends AppCompatActivity {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String username1 ;
    Map<String, Object> data = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionario2);

        //Botones header
        ImageButton boton_atras = findViewById(R.id.flecha_atras_questionario2);
        obtener_usuario();

        //Botones main
        Button boton_siguiente = findViewById(R.id.B_siguiente);

        //botones declarados toolbar
        Button botontoolbar_perfil = findViewById(R.id.B_perfil);
        Button botontoolbar_entrenamiento = findViewById(R.id.B_entrenamiento);
        Button botontoolbar_nutricion = findViewById(R.id.B_nutricion);

        //DECLARACION DE GROUPBUTTONS
        RadioGroup group_objetivo = findViewById(R.id.OBJETIVO);
        RadioGroup group_refnutr = findViewById(R.id.Ref_Nutr);

        //LISTENERS DE OBJETIVO RADIOBUTTONS
        group_objetivo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                if (radioButton != null) {
                    String opcionSeleccionada = radioButton.getText().toString();
                    data.put("objetivo", opcionSeleccionada );
                }
            }
        });

        //LISTENERS DE REFERENCIA NUTRICIONALES RADIOBUTTONS
        group_refnutr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                if (radioButton != null) {
                    String opcionSeleccionada = radioButton.getText().toString();
                    data.put("PrefNutr", opcionSeleccionada );
                }
            }
        });


        //ejecucion de los botones
        botontoolbar_perfil.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de perfil
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Questionario2.this, Perfil.class);
                startActivity(intent);
            }
        });

        botontoolbar_nutricion.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de nutricion
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Questionario2.this, Nutricion.class);
                startActivity(intent);
            }
        });

        botontoolbar_entrenamiento.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de entrenamiento
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Questionario2.this, Entrenamiento.class);
                startActivity(intent);
            }
        });

        boton_atras.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de atras
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Questionario2.this, Questionario1.class);
                startActivity(intent);
            }
        });

        boton_siguiente.setOnClickListener(new View.OnClickListener() { //ejecucion del botón siguiente
            @Override
            public void onClick(View view) {
                // Se inserta el Map en Firestore
                db.collection("usuarios").document(user.getEmail().toString()).update(data);
                Intent intent = new Intent(Questionario2.this, Questionario3.class);
                startActivity(intent);
            }
        });
    }



    public void obtener_usuario(){
        //textview declarado
        TextView username = findViewById(R.id.NombreUsuarioView);



        DocumentReference docRef = db.collection("usuarios").document(user.getEmail());

        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    username1= documentSnapshot.getString("username"); // Almacenamos el username en el array
                    username.setText(username1);
                    Log.d(TAG, "Username: " + username1);

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
