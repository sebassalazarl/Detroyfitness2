package com.example.detroyfitness2;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Nutricion extends AppCompatActivity {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String username1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutricion);

        //Botones header
        ImageButton boton_atras = findViewById(R.id.flecha_atras);
        ImageView foto_perfil = findViewById(R.id.foto_perfil);

        //Botones main
        ImageButton boton_evaluacioncorporal = findViewById(R.id.B_evaluacionCoporal);
        ImageButton boton_recetas = findViewById(R.id.B_recetas);
        ImageButton boton_plansemanal = findViewById(R.id.B_plansemanal);
        ImageButton boton_alimentos = findViewById(R.id.B_alimentos);

        //botones declarados toolbar
        Button botontoolbar_perfil = findViewById(R.id.B_perfil);
        Button botontoolbar_entrenamiento = findViewById(R.id.B_entrenamiento);
        Button botontoolbar_nutricion = findViewById(R.id.B_nutricion);

        //COMPROBACION DE FOTO PERFIL
        fotoperfil(foto_perfil);
        obtener_usuario();



        boton_plansemanal.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de perfil
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nutricion.this, Nutricion_plansemanal.class);
                startActivity(intent);
            }
        });
        //ejecucion de los botones
        botontoolbar_perfil.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de perfil
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nutricion.this, Perfil.class);
                startActivity(intent);
            }
        });

        botontoolbar_nutricion.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de nutricion
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nutricion.this, Nutricion.class);
                startActivity(intent);
            }
        });

        botontoolbar_entrenamiento.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de entrenamiento
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nutricion.this, Entrenamiento.class);
                startActivity(intent);
            }
        });

        boton_atras.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de atras
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nutricion.this, Pagina_principal.class);
                startActivity(intent);
            }
        });

        //botones de main para cambiar pantalla
        boton_evaluacioncorporal.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de evaluacio corporal
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nutricion.this, Nutricion.class);
                startActivity(intent);
            }
        });

        boton_recetas.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de recetas
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nutricion.this, Recetas.class);
                startActivity(intent);
            }
        });

        boton_alimentos.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de alimentos
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nutricion.this, Nutricion_alimentos.class);
                startActivity(intent);
            }
        });


    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    //en este metodo comprobamos si el usuario tiene una foto de perfil en caso de que tenga la mostramos
    public void fotoperfil(ImageView foto_perfil){

        DocumentReference docRef = db.collection("usuarios").document(user.getEmail());
        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    // Verificar si el campo "Foto_perfil" existe en el documento
                    if (document.contains("Foto_perfil")) {
                        // El campo "Foto_perfil" existe
                        String linkPerfil = document.getString("Foto_perfil");

                        //HACEMOS EN SEGUNDO PLANO LA CONEXION Y PASAMOS A BITMAP EL LINK DE LA IMAGEN
                        class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

                            @Override
                            protected Bitmap doInBackground(String... imageUrl) {
                                Bitmap bm = null;
                                try {
                                    URL url = new URL(imageUrl[0]);
                                    URLConnection con = url.openConnection();
                                    con.connect();
                                    InputStream is = con.getInputStream();
                                    BufferedInputStream bis = new BufferedInputStream(is);
                                    bm = BitmapFactory.decodeStream(bis);
                                    bis.close();
                                    is.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return bm;
                            }

                            @Override
                            protected void onPostExecute(Bitmap result) {

                                foto_perfil.setImageBitmap(result);
                                // Actualiza la UI con la imagen descargada

                            }
                        }

                        new DownloadImageTask().execute(linkPerfil);

                    } else {
                        // El campo "Foto_perfil" no existe
                    }
                } else {
                    // El documento no existe
                }
            } else {
                // Error al obtener el documento
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
