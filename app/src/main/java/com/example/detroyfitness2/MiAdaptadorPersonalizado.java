package com.example.detroyfitness2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptadorPersonalizado extends RecyclerView.Adapter<MiAdaptadorPersonalizado.ViewHolder> {
    private List<Alimentos> listaAlimentos;

    public MiAdaptadorPersonalizado(List<Alimentos> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
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
