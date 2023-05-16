package com.example.detroyfitness2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Entrenamiento_planes_iniciacion_rutina extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrenamiento_planes_iniciacion_rutina);

        //Botones Header
        ImageButton boton_atras = findViewById(R.id.B_flecha_atras_entrenamiento);

        //Botones main
        /*Button boton_funcional_dia1 = findViewById(R.id.B_rutinaFuncional_dia1);
        Button boton_funcional_dia2 = findViewById(R.id.B_rutinaFuncional_dia2);
        Button boton_funcional_dia3 = findViewById(R.id.B_rutinaFuncional_dia3);
        Button boton_funcional_dia4 = findViewById(R.id.B_rutinaFuncional_dia4);
        Button boton_funcional_dia5 = findViewById(R.id.B_rutinaFuncional_dia5);*/

        //botones declarados toolbar
        Button botontoolbar_perfil = findViewById(R.id.B_perfil);
        Button botontoolbar_entrenamiento = findViewById(R.id.B_entrenamiento);
        Button botontoolbar_nutricion = findViewById(R.id.B_nutricion);

        //ejecucion de los botones
        botontoolbar_perfil.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de perfil
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_iniciacion_rutina.this, Perfil.class);
                startActivity(intent);
            }
        });

        botontoolbar_nutricion.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de nutricion
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_iniciacion_rutina.this, Nutricion.class);
                startActivity(intent);
            }
        });

        botontoolbar_entrenamiento.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de entrenamiento
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_iniciacion_rutina.this, Entrenamiento.class);
                startActivity(intent);
            }
    });

        boton_atras.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de atras
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_iniciacion_rutina.this, Entrenamiento_planes_iniciacion.class);
                startActivity(intent);
            }
        });
//==================================================================================================
        //botones de main para cambiar pantalla

        //ejecucion del botón de entrenamiento funcional
        /*boton_funcional_dia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_funcional_rutina.this, .class);
                startActivity(intent);
            }
        });

        //ejecucion del botón de entrenamiento de hipertrofia
        boton_hipertrofia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_funcional_rutina.this, Pagina_principal.class);
                startActivity(intent);
            }
        });

        //ejecucion del botón de entrenamiento de iniciación
        boton_iniciacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_funcional_rutina.this, Pagina_principal.class);
                startActivity(intent);
            }
        });

        //ejecucion del botón de entrenamiento de perdida de grasa
        boton_perdida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_planes_funcional_rutina.this, Pagina_principal.class);
                startActivity(intent);
            }
        });*/

}
}