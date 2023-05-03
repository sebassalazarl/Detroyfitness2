package com.example.detroyfitness2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Entrenamiento_sobrecarga_2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrenamiento_sobrecarga_2);

        //Botones Header
        ImageButton boton_atras = findViewById(R.id.flecha_atras);

        //Boton de calcular
        Button boton_calcular = findViewById(R.id.b_calcular);

        //El usuario introduce el numero
        EditText editTextNumber = findViewById(R.id.editTextNumber);

        //Resultados de las semanas
        TextView resultlunes1 = findViewById(R.id.resultadoluness1);
        TextView resultjueves1 = findViewById(R.id.resultadojuevess1);

        TextView resultlunes2 = findViewById(R.id.resultadoluness2);
        TextView resultjueves2 = findViewById(R.id.resultadojuevess2);

        TextView resultlunes3 = findViewById(R.id.resultadoluness3);
        TextView resultjueves3 = findViewById(R.id.resultadojuevess3);

        TextView resultlunes4 = findViewById(R.id.resultadoluness4);
        TextView resultjueves4 = findViewById(R.id.resultadojuevess4);



        //botones declarados toolbar
        Button botontoolbar_perfil = findViewById(R.id.B_perfil);
        Button botontoolbar_entrenamiento = findViewById(R.id.B_entrenamiento);
        Button botontoolbar_nutricion = findViewById(R.id.B_nutricion);

        //ejecucion de los botones
        botontoolbar_perfil.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de perfil
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_sobrecarga_2.this, Perfil.class);
                startActivity(intent);
            }
        });

        botontoolbar_nutricion.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de nutricion
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_sobrecarga_2.this, Nutricion.class);
                startActivity(intent);
            }
        });

        botontoolbar_entrenamiento.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de entrenamiento
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_sobrecarga_2.this, Entrenamiento_sobrecarga_2.class);
                startActivity(intent);
            }
    });

        boton_atras.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de atras
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Entrenamiento_sobrecarga_2.this, Entrenamiento_sobrecarga.class);
                startActivity(intent);
            }
        });
//==================================================================================================
    //BOTONES
        //CALCULO DE TODOS LOS RESULTADOS
        boton_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtenemos el valor ingresado por el usuario y lo convertimos a un número entero
                int number = Integer.parseInt(editTextNumber.getText().toString());

                // Realizamos las operaciones para cada resultado
                // Semana 1
                int resultLlun1 = number * 65/100;
                int resultLjue1 = number * 65/100;

                // Semana 2
                int resultLlun2 = number * 75/100;
                int resultLjue2 = number * 75/100;

                // Semana 3
                int resultLlun3 = number * 85/100;
                int resultLjue3 = number * 85/100;

                // Semana 4
                int resultLlun4 = number * 92/100;
                int resultLjue4 = number * 92/100;

                // Actualizamos el texto del TextView con el resultado
                // Semana 1
                resultlunes1.setText("" + resultLlun1);
                resultjueves1.setText("" + resultLjue1);

                // Semana 2
                resultlunes2.setText("" + resultLlun2);
                resultjueves2.setText("" + resultLjue2);

                // Semana 3
                resultlunes3.setText("" + resultLlun3);
                resultjueves3.setText("" + resultLjue3);

                // Semana 4
                resultlunes4.setText("" + resultLlun4);
                resultjueves4.setText("" + resultLjue4);
            }
        });

}
}