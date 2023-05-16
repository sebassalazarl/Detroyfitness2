package com.example.detroyfitness2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Recetas extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recetas);

        //Botones header
        ImageButton boton_atras = findViewById(R.id.flecha_atras_recetas);

        //botones main
        ImageButton receta1 = findViewById(R.id.B_receta1);
        ImageButton receta2 = findViewById(R.id.B_receta2);
        //botones declarados toolbar
        Button botontoolbar_perfil = findViewById(R.id.B_perfil);
        Button botontoolbar_entrenamiento = findViewById(R.id.B_entrenamiento);
        Button botontoolbar_nutricion = findViewById(R.id.B_nutricion);

        //ejecucion de los botones
        botontoolbar_perfil.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de perfil
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Recetas.this, Perfil.class);
                startActivity(intent);
            }
        });

        receta1.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de nutricion
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Recetas.this, Videos_recetas.class);

                // Agrega la variable a la intención
                String receta = "receta_calabaza";
                String link ="https://firebasestorage.googleapis.com/v0/b/detroy-fitness-e203b.appspot.com/o/videos_recetas%2Fcream_calabaza.mp4?alt=media&token=95dd8e44-1b73-408d-b3ee-491beac9688b" ;
                intent.putExtra("link", link);
                intent.putExtra("receta", receta);

                // Lanza la actividad
                startActivity(intent);
            }
        });

        receta2.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de nutricion
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Recetas.this, Videos_recetas.class);

                // Agrega la variable a la intención
                String receta = "receta_mouse";
                String link = "https://firebasestorage.googleapis.com/v0/b/detroy-fitness-e203b.appspot.com/o/videos_recetas%2Fmouse_de_chocolate.mp4?alt=media&token=a81425fe-3047-4237-bcb8-09fba5657648";
                intent.putExtra("link", link);
                intent.putExtra("receta", receta);

                // Lanza la actividad
                startActivity(intent);
            }
        });

        botontoolbar_nutricion.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de nutricion
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Recetas.this, Nutricion.class);
                startActivity(intent);
            }
        });

        botontoolbar_entrenamiento.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de entrenamiento
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Recetas.this, Entrenamiento.class);
                startActivity(intent);
            }
        });

        boton_atras.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de atras
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Recetas.this, Nutricion.class);
                startActivity(intent);
            }
        });


    }

}
