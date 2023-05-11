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

public class Adaptador_dietas extends RecyclerView.Adapter<Adaptador_dietas.ViewHolder> {
    private List<dieta> listaSemanal;
    private FirebaseFirestore db;

    public Adaptador_dietas(List<dieta> listaSemanal) {
        this.listaSemanal = listaSemanal;
        db = FirebaseFirestore.getInstance();
        db.collection("dietas").document("dieta1").collection("dias")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            Log.w(TAG, "Error al obtener los datos", error);
                            return;
                        }

                        listaSemanal.clear();
                        for (DocumentSnapshot document : value) {
                            if (document.exists()) {
                                dieta dieta = document.toObject(dieta.class);
                                listaSemanal.add(dieta);

                            }
                        }
                        notifyDataSetChanged();
                    }
                });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.style_dieta, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        dieta dieta = listaSemanal.get(position);
        holder.desayunoTextView.setText(dieta.getDesayuno());
        holder.almuerzoTextView.setText(dieta.getAlmuerzo());
        holder.comidaTextView.setText(dieta.getComida());
        holder.meriendaTextView.setText(dieta.getMerienda());
        holder.cenaTextView.setText(dieta.getCena());
        holder.diaTextView.setText(dieta.getDia());
    }

    @Override
    public int getItemCount() {
        return listaSemanal.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView desayunoTextView;
        public TextView almuerzoTextView;
        public TextView comidaTextView;
        public TextView meriendaTextView;
        public TextView cenaTextView;
        public TextView diaTextView;



        public ViewHolder(View itemView) {
            super(itemView);


            diaTextView = itemView.findViewById(R.id.DiaSemana);
            desayunoTextView = itemView.findViewById(R.id.comida1);
            almuerzoTextView = itemView.findViewById(R.id.comida2);
            comidaTextView = itemView.findViewById(R.id.comida3);
            meriendaTextView = itemView.findViewById(R.id.comida4);
            cenaTextView = itemView.findViewById(R.id.comida5);
        }
    }

}

