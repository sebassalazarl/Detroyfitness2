package com.example.detroyfitness2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Videos_recetas extends AppCompatActivity {

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference().child("videos_recetas/cream_calabaza.mp4");
    String videoUrl = "https://firebasestorage.googleapis.com/v0/b/detroy-fitness-e203b.appspot.com/o/videos_recetas%2Fcream_calabaza.mp4?alt=media&token=95dd8e44-1b73-408d-b3ee-491beac9688b";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videos_recetas);

        //Botones header
        ImageButton boton_atras = findViewById(R.id.flecha_atras);

        //video
        VideoView videoView = findViewById(R.id.videoView);
       // videoView.setVideoURI(Uri.parse(storageRef.toString()));

        Uri uri = Uri.parse(videoUrl);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.start();


        //botones declarados
        Button botontoolbar_perfil = findViewById(R.id.B_perfil);
        Button botontoolbar_entrenamiento = findViewById(R.id.B_entrenamiento);
        Button botontoolbar_nutricion = findViewById(R.id.B_nutricion);

        //ejecucion de los botones
        botontoolbar_perfil.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de perfil
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Videos_recetas.this, Perfil.class);
                startActivity(intent);
            }
        });

        botontoolbar_nutricion.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de nutricion
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Videos_recetas.this, Nutricion.class);
                startActivity(intent);
            }
        });

        botontoolbar_entrenamiento.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de entrenamiento
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Videos_recetas.this, Entrenamiento.class);
                startActivity(intent);
            }
        });
        boton_atras.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de atras
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Videos_recetas.this, Pagina_principal.class);
                startActivity(intent);
            }
        });
    }
}
