package com.softchan.agendaescolar.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.dbroom.Agenda;
import com.softchan.agendaescolar.dbroom.DBAcces;
import com.softchan.agendaescolar.dbroom.Note;

import java.util.List;

public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.ViewHolder> {

    private List<Agenda> agendaDataList;
    private Activity context;

    public AgendaAdapter(Activity context, List<Agenda> agendaDataList){
        this.context = context;
        this.agendaDataList = agendaDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // iniciaizar el view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_agenda, parent, false);
        return new AgendaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // inicializar los datos principales
        Agenda data = agendaDataList.get(position);
        // inicializar la base de datos
        // visualizar el texto en el textview
        if(data.getCategoria() == DBAcces.optionLessonDAO){
            holder.categoria.setText(data.getCategoria());
            holder.titulo.setText(data.getAsignatura());
            holder.hora.setText(data.getHora());
            holder.aula.setText(data.getAula());
            holder.profesor.setText(data.getNameProfesor());

            // ----------------------------------- acomodar dos fechas en el recyclerview

        }else{
            holder.categoria.setText(data.getCategoria());
            holder.titulo.setText(data.getTitulo());
            holder.hora.setText(data.getAsignatura());
            holder.aula.setText(data.getFechaEntrega());
            holder.profesor.setText(data.getDescripcion());
        }
    }

    @Override
    public int getItemCount() {
        return agendaDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoria;
        TextView titulo;
        TextView hora;
        TextView aula;
        TextView profesor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // asignacion de variables
            categoria = itemView.findViewById(R.id.categoria);
            titulo = itemView.findViewById(R.id.titulo);
            hora = itemView.findViewById(R.id.hora);
            aula = itemView.findViewById(R.id.aula);
            profesor = itemView.findViewById(R.id.profesor);

        }
    }
}
