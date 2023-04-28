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

public class MiAdaptadorPersonalizado extends RecyclerView.Adapter<MiAdaptadorPersonalizado.ViewHolder> {
    private List<Alimentos> listaAlimentos;
    private FirebaseFirestore db;

    public MiAdaptadorPersonalizado(List<Alimentos> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
        db = FirebaseFirestore.getInstance();
        db.collection("alimentos")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            Log.w(TAG, "Error al obtener los datos", error);
                            return;
                        }

                        listaAlimentos.clear();
                        for (DocumentSnapshot document : value) {
                            if (document.exists()) {
                                Alimentos alimento = document.toObject(Alimentos.class);
                                listaAlimentos.add(alimento);
                            }
                        }
                        notifyDataSetChanged();
                    }
                });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.style_alimentos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Alimentos alimento = listaAlimentos.get(position);
        holder.nombreTextView.setText(alimento.getNombre());
        holder.kcalTextView.setText(alimento.getKcal());
        holder.proteinaTextView.setText(alimento.getProteina());
        holder.grasasTextView.setText(alimento.getGrasas());
        holder.carbohidratosTextView.setText(alimento.getCarbohidratos());
    }

    @Override
    public int getItemCount() {
        return listaAlimentos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombreTextView;
        public TextView kcalTextView;
        public TextView proteinaTextView;
        public TextView grasasTextView;
        public TextView carbohidratosTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            nombreTextView = itemView.findViewById(R.id.nombre_text);
            kcalTextView = itemView.findViewById(R.id.kcal_text);
            proteinaTextView = itemView.findViewById(R.id.proteina_text);
            grasasTextView = itemView.findViewById(R.id.grasas_text);
            carbohidratosTextView = itemView.findViewById(R.id.carbo_text);
        }
    }
}

