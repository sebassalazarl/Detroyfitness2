package com.example.detroyfitness2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Entrenamiento extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrenamiento);

        //Botones Header
        ImageButton boton_atras = findViewById(R.id.B_flecha_atras_entrenamiento);

        //Botones main
        ImageButton boton_planentrenamiento = findViewById(R.id.B_planEntrenamiento);
        ImageButton boton_desafiosemanal = findViewById(R.id.B_desafioSemanal);
        ImageButton boton_sobrecarga = findViewById(R.id.B_sobrecargaProgresiva);
        ImageButton boton_tecnica = findViewById(R.id.B_tecnica);

        //botones declarados toolbar
        Button botontoolbar_perfil = findViewById(R.id.B_perfil);
        Button botontoolbar_entrenamiento = findViewById(R.id.B_entrenamiento);
        Button botontoolbar_nutricion = findViewById(R.id.B_nutricion);

        //ejecucion de los botones
        botontoolbar_perfil.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de perfil
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento.this, Perfil.class);
                startActivity(intent);
            }
        });

        botontoolbar_nutricion.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de nutricion
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento.this, Nutricion.class);
                startActivity(intent);
            }
        });

        botontoolbar_entrenamiento.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de entrenamiento
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento.this, Entrenamiento.class);
                startActivity(intent);
            }
    });

        boton_atras.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de atras
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento.this, Pagina_principal.class);
                startActivity(intent);
            }
        });

        //botones de main para cambiar pantalla
        boton_planentrenamiento.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de plan de entrenamiento
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento.this, Entrenamiento_planes.class);
                startActivity(intent);
            }
        });

        boton_desafiosemanal.setOnClickListener(new View.OnClickListener() { //ejecucion del botón del desafio semanal
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento.this, Entrenamiento_desafio.class);
                startActivity(intent);
            }
        });

        boton_sobrecarga.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de la sobrecarga progresiva
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento.this, Entrenamiento_sobrecarga.class);
                startActivity(intent);
            }
        });

        boton_tecnica.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de tecnica
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento.this, Entrenamiento_tecnica.class);
                startActivity(intent);
            }
        });

}
}