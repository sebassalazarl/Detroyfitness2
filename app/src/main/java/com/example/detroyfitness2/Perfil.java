package com.example.detroyfitness2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class Perfil extends AppCompatActivity {

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference mStorageRef = storage.getReference();
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri mImageUri;
    ImageButton Cambiar_perfil;
    ImageView FotoPerfil;
    Map<String, Object> data = new HashMap<>();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_perfil);

        //Botones Header
        ImageButton boton_atras = findViewById(R.id.flecha_atras);

        //Botones main
        Button boton_cerrarsesion = findViewById(R.id.Cerrar_sesion);
        Cambiar_perfil = findViewById(R.id.Cambiar_perfil);
        FotoPerfil = findViewById(R.id.Imagen_perfl);
        ImageButton btncambiar_username = findViewById(R.id.B_cambiarnombre);
        ImageButton btncambiarcontraseña = findViewById(R.id.B_cambiarcontraseña);
        ImageButton Btn_cambiarpeso = findViewById(R.id.B_cambiarpeso);

        //EditText main
        EditText CambiarPeso = findViewById(R.id.CambiarPeso);
        EditText cambiarnombre = findViewById(R.id.Cambiarnombre);
        EditText cambiarcontraseña = findViewById(R.id.cambiarcontraseña);

        //COMPROBACION DE FOTO PERFIL
        fotoperfil(FotoPerfil);

        //botones declarados toolbar
        Button botontoolbar_perfil = findViewById(R.id.B_perfil);
        Button botontoolbar_entrenamiento = findViewById(R.id.B_entrenamiento);
        Button botontoolbar_nutricion = findViewById(R.id.B_nutricion);

        //ejecucion de los botones
        Cambiar_perfil.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de subir foto para cambiar perfil
            @Override
            public void onClick(View view) {
               SubirImg();

            }
        });

        btncambiar_username.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de cambiar username
            @Override
            public void onClick(View view) {
                String datoCambiado = cambiarnombre.getText().toString().trim();
                cambiarDatos_User("username",datoCambiado, "nombre de usuario");
                Intent intent = new Intent(Perfil.this, Perfil.class);
                startActivity(intent);
            }
        });

        Btn_cambiarpeso.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de cambiar peso
            @Override
            public void onClick(View view) {
                String datoCambiado = CambiarPeso.getText().toString().trim();
                cambiarDatos_User("peso",datoCambiado, "peso");
                Intent intent = new Intent(Perfil.this, Perfil.class);
                startActivity(intent);
            }
        });

        btncambiarcontraseña.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de cambiar contraseña
            @Override
            public void onClick(View view) {
                String inputcontraseña = cambiarcontraseña.getText().toString().trim();
                cambiarpassword(inputcontraseña);
                Intent intent = new Intent(Perfil.this, Perfil.class);
                startActivity(intent);
            }
        });

        botontoolbar_perfil.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de perfil
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfil.this, Perfil.class);
                startActivity(intent);
            }
        });

        botontoolbar_nutricion.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de nutricion
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfil.this, Nutricion.class);
                startActivity(intent);

            }
        });

        botontoolbar_entrenamiento.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de entrenamiento
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfil.this, Entrenamiento.class);
                startActivity(intent);
            }
        });

        boton_atras.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de atras
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfil.this, Pagina_principal.class);
                startActivity(intent);
            }
        });

        boton_cerrarsesion.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de cerrar sesion
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Perfil.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void SubirImg(){
        // Crear una referencia a la imagen que se va a subir
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Selecciona una imagen"), PICK_IMAGE_REQUEST);

    }
    @Override
    protected void onActivityResult(int requestCode , int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            mImageUri = data.getData();

            // Subir la imagen al Firebase Storage
            StorageReference fileReference = mStorageRef.child("img_perfil/" + FirebaseAuth.getInstance().getCurrentUser().getUid() + ".jpg");
            fileReference.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    // La imagen se ha subido correctamente
                    Toast.makeText(Perfil.this, "Imagen subida correctamente", Toast.LENGTH_SHORT).show();

                    // Obtener la URL de la imagen subida
                    fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                             String imageUrl = uri.toString();

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
                                    guardarlink( imageUrl);
                                    FotoPerfil = findViewById(R.id.Imagen_perfl);
                                    FotoPerfil.setImageBitmap(result);
                                    // Actualiza la UI con la imagen descargada
                                }
                            }
                            new DownloadImageTask().execute(imageUrl);
                        }
                    });
                }
            });
        }
        }
    //en este metodo comprobamos si el usuario tiene una foto de perfil en caso de que tenga la mostramos
    public void fotoperfil(ImageView FotoPerfil){

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

                                FotoPerfil.setImageBitmap(result);
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
        public void guardarlink(String imageUrl){
            data.put("Foto_perfil", imageUrl);

            // Se inserta el Map en Firestore
            db.collection("usuarios").document(user.getEmail().toString()).update(data);
        }

        //FUNCION PARA CAMBIAR DATOS DEL USAURIO QUE SENA NECESARIOS
        public void cambiarDatos_User(String opcion_elejida, String dato_cambiado, String dato){
            data.put(opcion_elejida, dato_cambiado);
            // Se inserta el Map en Firestore
            db.collection("usuarios").document(user.getEmail().toString()).update(data);
            Toast.makeText(Perfil.this, "Su "+dato+" se ha actualizado correctamente", Toast.LENGTH_SHORT).show();
        }
        //FUNCION PARA CAMBIAR LA CONTRASEÑA DEL USUARIO
        public void cambiarpassword(String newPassword){
            user.updatePassword(newPassword)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                // Contraseña actualizada exitosamente
                            } else {
                                // Hubo un error al actualizar la contraseña
                            }
                        }
                    });
        }



}




