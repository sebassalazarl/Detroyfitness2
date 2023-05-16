package com.example.detroyfitness2;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.checkerframework.checker.nullness.qual.NonNull;

public class Videos_recetas extends AppCompatActivity {

    FirebaseStorage storage = FirebaseStorage.getInstance();

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    TextView i1, i2, i3, i4, i5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videos_recetas);


        // Recupera el Intent que inició esta actividad
        Intent intent = getIntent();
        String link = getIntent().getStringExtra("link");
        String recetas = getIntent().getStringExtra("receta");

        recuperar_receta(recetas);

        //Botones header
        ImageButton boton_atras = findViewById(R.id.flecha_atras);

        //video
        VideoView videoView = findViewById(R.id.videoView);
       // videoView.setVideoURI(Uri.parse(storageRef.toString()));

        Uri uri = Uri.parse(link);
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

    public void  recuperar_receta(String recetas){

        //textview declarado
        i1 = findViewById(R.id.i_1);
        i2 = findViewById(R.id.i_2);
        i3 = findViewById(R.id.i_3);
        i4 = findViewById(R.id.i_4);
        i5 = findViewById(R.id.i_5);

        //le declaro que la receta que quiero que vea
        DocumentReference docRef = db.collection("videos").document(recetas);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String ingrediente1= documentSnapshot.getString("i_1"); // Almacenamos el ingrediente en el array
                    i1.setText(ingrediente1);

                    String ingrediente2= documentSnapshot.getString("i_2"); // Almacenamos el ingrediente en el array
                    i2.setText(ingrediente2);

                    String ingrediente3= documentSnapshot.getString("i_3"); // Almacenamos el ingrediente en el array
                    i3.setText(ingrediente3);

                    String ingrediente4= documentSnapshot.getString("i_4"); // Almacenamos el ingrediente en el array
                    i4.setText(ingrediente4);

                    String ingrediente5= documentSnapshot.getString("i_5"); // Almacenamos el ingrediente en el array
                    i5.setText(ingrediente5);


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
