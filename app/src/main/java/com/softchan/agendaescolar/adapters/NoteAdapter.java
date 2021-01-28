package com.softchan.agendaescolar.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.dbroom.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private List<Note> noteDataList;
    private Activity context;

    public NoteAdapter(Activity context, List<Note> noteDataList){
        this.context = context;
        this.noteDataList = noteDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // iniciaizar el view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_notas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // inicializar los datos principales
        Note data = noteDataList.get(position);
        // visualizar el texto en el textview
        holder.nota.setText(data.getNota());
    }

    @Override
    public int getItemCount() {
        return noteDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nota;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // asignacion de variables
            nota = itemView.findViewById(R.id.note);

        }
    }
}
