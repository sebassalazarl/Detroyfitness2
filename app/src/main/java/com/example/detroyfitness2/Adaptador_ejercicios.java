package com.example.detroyfitness2;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class Adaptador_ejercicios extends RecyclerView.Adapter<Adaptador_ejercicios.ViewHolder> {
    private List<Ejercicios> listaEjercicios;
    String dia_eje;
    private FirebaseFirestore db;

    public Adaptador_ejercicios(List<Ejercicios> listaEjercicios, String dia_eje) {
        this.listaEjercicios = listaEjercicios;
        this.dia_eje = dia_eje;

        db = FirebaseFirestore.getInstance();
        db.collection("rutinas").document("funcional").collection("rutina3").document(dia_eje).collection("ejercicios")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            Log.w(TAG, "Error al obtener los datos", error);
                            return;
                        }

                        listaEjercicios.clear();
                        for (DocumentSnapshot document : value) {
                            if (document.exists()) {
                                Ejercicios ejercicios = document.toObject(Ejercicios.class);
                                listaEjercicios.add(ejercicios);

                            }
                        }
                        notifyDataSetChanged();
                    }
                });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.style_ejerciciorutina, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Ejercicios ejercicios = listaEjercicios.get(position);
        holder.diaTextView.setText(ejercicios.getNombre());
        holder.series.setText(ejercicios.getSeries());
        holder.repes.setText(ejercicios.getRepeticiones());

    }

    @Override
    public int getItemCount() {
        return listaEjercicios.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView diaTextView;
        public TextView series;
        public TextView repes;


        public ViewHolder(View itemView) {
            super(itemView);

            diaTextView = itemView.findViewById(R.id.nombre_eje);
            series = itemView.findViewById(R.id.series_eje);
            repes = itemView.findViewById(R.id.repeticiones_eje);

        }
    }
}
