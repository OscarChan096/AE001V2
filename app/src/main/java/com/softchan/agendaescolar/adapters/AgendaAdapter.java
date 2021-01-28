package com.softchan.agendaescolar.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.dbroom.DBAcces;
import com.softchan.agendaescolar.dbroom.Note;

import java.util.List;

public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.ViewHolder> {

    private List<Note> agendaDataList;
    private Activity context;
    private DBAcces database;

    public AgendaAdapter(Activity context, List<Note> noteDataList){
        this.context = context;
        this.agendaDataList = noteDataList;
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
        Note data = agendaDataList.get(position);
        // inicializar la base de datos
        database = DBAcces.getInstance(context, 3);
        // visualizar el texto en el textview
        //holder.nota.setText(data.getNota());
    }

    @Override
    public int getItemCount() {
        return agendaDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView asigntura;
        TextView hora_empiezo;
        TextView hora_fin;
        TextView aula;
        TextView profesor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // asignacion de variables
            //nota = itemView.findViewById(R.id.note);

        }
    }
}
