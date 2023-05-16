package com.example.detroyfitness2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptadorVideos extends RecyclerView.Adapter<MiAdaptadorVideos.ViewHolder> {
    private List<Tecnica> listaTecnicas;
    private Context context;



    public MiAdaptadorVideos(List<Tecnica> listaTecnicas, Context context) {
        this.listaTecnicas = listaTecnicas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.style_tecnica, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tecnica tecnica = listaTecnicas.get(position);
        holder.nombreTecnica.setText(tecnica.getNombre());

        //
        holder.Bind(tecnica);
    }

    @Override
    public int getItemCount() {
        return listaTecnicas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder { // button_tecnica
        TextView nombreTecnica;
        public Button b_tecnica;
        public String URL;
        private Tecnica tecnica1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTecnica = itemView.findViewById(R.id.nombre_tecnica);
            b_tecnica = itemView.findViewById(R.id.button_tecnica);



            //ejecucion de
            b_tecnica.setOnClickListener(new View.OnClickListener() { //ejecucion del botón de perfil
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(view.getContext(), Videos_tecnica.class);

                    intent.putExtra("url",tecnica1.getUrl());
                    view.getContext().startActivity(intent);

                }
            });
        }
        public void Bind(Tecnica tecnica) {
            tecnica1 = tecnica;
        }
    }

}