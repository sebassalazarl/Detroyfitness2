package com.example.detroyfitness2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Entrenamiento_planes_hipertrofia extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrenamiento_planes_hipertrofia);

        //Botones Header
        ImageButton boton_atras = findViewById(R.id.B_flecha_atras_entrenamiento);

        //Botones main
        Button boton_hipertrofia_dia1 = findViewById(R.id.B_rutinaHipertrofia_dia1);
        Button boton_hipertrofia_dia2 = findViewById(R.id.B_rutinaHipertrofia_dia2);
        Button boton_hipertrofia_dia3 = findViewById(R.id.B_rutinaHipertrofia_dia3);
        Button boton_hipertrofia_dia4 = findViewById(R.id.B_rutinaHipertrofia_dia4);
        Button boton_hipertrofia_dia5 = findViewById(R.id.B_rutinaHipertrofia_dia5);

        //botones declarados toolbar
        Button botontoolbar_perfil = findViewById(R.id.B_perfil);
        Button botontoolbar_entrenamiento = findViewById(R.id.B_entrenamiento);
        Button botontoolbar_nutricion = findViewById(R.id.B_nutricion);

//==================================================================================================
        //ejecucion de los botones
        botontoolbar_perfil.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de perfil
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_hipertrofia.this, Perfil.class);
                startActivity(intent);
            }
        });

        botontoolbar_nutricion.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de nutricion
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_hipertrofia.this, Nutricion.class);
                startActivity(intent);
            }
        });

        botontoolbar_entrenamiento.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de entrenamiento
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_hipertrofia.this, Entrenamiento_planes_hipertrofia.class);
                startActivity(intent);
            }
    });

        boton_atras.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de atras
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_hipertrofia.this, Entrenamiento_planes.class);
                startActivity(intent);
            }
        });
//==================================================================================================
        //botones de main para cambiar pantalla

        //ejecucion del botón de entrenamiento funcional DIA 1
        boton_hipertrofia_dia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_hipertrofia.this, Entrenamiento_planes_hipertrofia_rutina.class);
                startActivity(intent);
            }
        });
        //ejecucion del botón de entrenamiento funcional DIA 2
        boton_hipertrofia_dia2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_hipertrofia.this, Entrenamiento_planes_hipertrofia_rutina.class);
                startActivity(intent);
            }
        });
        //ejecucion del botón de entrenamiento funcional DIA 3
        boton_hipertrofia_dia3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_hipertrofia.this, Entrenamiento_planes_hipertrofia_rutina.class);
                startActivity(intent);
            }
        });
        //ejecucion del botón de entrenamiento funcional DIA 4
        boton_hipertrofia_dia4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_hipertrofia.this, Entrenamiento_planes_hipertrofia_rutina.class);
                startActivity(intent);
            }
        });
        //ejecucion del botón de entrenamiento funcional DIA 5
        boton_hipertrofia_dia5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_hipertrofia.this, Entrenamiento_planes_funcional_rutina.class);
                startActivity(intent);
            }
        });



}
}