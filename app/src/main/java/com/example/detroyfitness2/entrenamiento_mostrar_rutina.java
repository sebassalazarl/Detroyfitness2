package com.example.detroyfitness2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class entrenamiento_mostrar_rutina extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrenamiento_mostrar_rutina);

        //Botones Header
        ImageButton boton_atras = findViewById(R.id.B_flecha_atras_entrenamiento);

        //botones declarados toolbar
        Button botontoolbar_perfil = findViewById(R.id.B_perfil);
        Button botontoolbar_entrenamiento = findViewById(R.id.B_entrenamiento);
        Button botontoolbar_nutricion = findViewById(R.id.B_nutricion);

        Intent intent = getIntent();
        String tipo_rutina = intent.getStringExtra("tipo_rutina");
        String dias_rutina = intent.getStringExtra("dias_rutina");
        String id = intent.getStringExtra("id");
        rutinas_lista(tipo_rutina, dias_rutina,id);

        //ejecucion de los botones
        botontoolbar_perfil.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de perfil
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entrenamiento_mostrar_rutina.this, Perfil.class);
                startActivity(intent);
            }
        });

        botontoolbar_nutricion.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de nutricion
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entrenamiento_mostrar_rutina.this, Nutricion.class);
                startActivity(intent);
            }
        });

        botontoolbar_entrenamiento.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de entrenamiento
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entrenamiento_mostrar_rutina.this, Entrenamiento_planes_funcional_rutina.class);
                startActivity(intent);
            }
        });

        boton_atras.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de atras
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entrenamiento_mostrar_rutina.this, Entrenamiento_planes_funcional.class);
                startActivity(intent);
            }
        });
    }
    public void rutinas_lista(String tipo_rutina , String dias_rutina, String id){

        System.out.println(id);

        ArrayList<Ejercicios> listaejercicios = new ArrayList<>();
        RecyclerView container_ejercicios = findViewById(R.id.container_ejercicios);

        container_ejercicios.setLayoutManager(new LinearLayoutManager(this));
        Adaptador_ejercicios adapter = new Adaptador_ejercicios(listaejercicios, tipo_rutina,dias_rutina,id );
        container_ejercicios.setAdapter(adapter);
    }
}