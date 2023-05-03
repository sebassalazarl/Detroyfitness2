package com.example.detroyfitness2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Entrenamiento_sobrecarga extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrenamiento_sobrecarga);

        //Botones Header
        ImageButton boton_atras = findViewById(R.id.flecha_atras);

        //Botones main
        ImageButton boton_excel = findViewById(R.id.b_excel);

        //botones declarados toolbar
        Button botontoolbar_perfil = findViewById(R.id.B_perfil);
        Button botontoolbar_entrenamiento = findViewById(R.id.B_entrenamiento);
        Button botontoolbar_nutricion = findViewById(R.id.B_nutricion);

        //ejecucion de los botones
        botontoolbar_perfil.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de perfil
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_sobrecarga.this, Perfil.class);
                startActivity(intent);
            }
        });

        botontoolbar_nutricion.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de nutricion
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_sobrecarga.this, Nutricion.class);
                startActivity(intent);
            }
        });

        botontoolbar_entrenamiento.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de entrenamiento
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_sobrecarga.this, Entrenamiento_sobrecarga.class);
                startActivity(intent);
            }
    });

        boton_atras.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de atras
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_sobrecarga.this, Entrenamiento.class);
                startActivity(intent);
            }
        });
//==================================================================================================
        //botones de main para cambiar pantalla

        //ejecucion del botón de excel
        boton_excel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_sobrecarga.this, Entrenamiento_sobrecarga_2.class);
                startActivity(intent);
            }
        });



}
}