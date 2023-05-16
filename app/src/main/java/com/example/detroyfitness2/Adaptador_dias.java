package com.example.detroyfitness2;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Adaptador_dias extends RecyclerView.Adapter<Adaptador_dias.ViewHolder> {
    private List<Dia> listaDias;
    private FirebaseFirestore db;

    public Adaptador_dias(List<Dia> listaDias) {
        this.listaDias = listaDias;
        db = FirebaseFirestore.getInstance();
        db.collection("rutinas").document("funcional").collection("rutina3")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            Log.w(TAG, "Error al obtener los datos", error);
                            return;
                        }

                        listaDias.clear();
                        for (DocumentSnapshot document : value) {
                            if (document.exists()) {
                                Dia dia = document.toObject(Dia.class);
                                listaDias.add(dia);

                            }
                        }
                        notifyDataSetChanged();
                    }
                });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.style_diasrutina, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Dia dia = listaDias.get(position);
        holder.diaTextView.setText(dia.getDia());

    }

    @Override
    public int getItemCount() {
        return listaDias.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView diaTextView;
        public RecyclerView container_ejercicios;



        public ViewHolder(View itemView) {
            super(itemView);


            diaTextView = itemView.findViewById(R.id.dia_ejer);
            String dia_eje = diaTextView.getText().toString();

            ArrayList<Ejercicios> listaEjercicios = new ArrayList<>();


            container_ejercicios = itemView.findViewById(R.id.container_ejercicios);
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            container_ejercicios.setLayoutManager(layoutManager);

            Adaptador_ejercicios adapter_ejercicios = new Adaptador_ejercicios(listaEjercicios, dia_eje);
            container_ejercicios.setAdapter(adapter_ejercicios);




        }

    }

}