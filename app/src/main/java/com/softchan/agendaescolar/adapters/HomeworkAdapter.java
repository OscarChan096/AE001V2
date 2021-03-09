package com.softchan.agendaescolar.adapters;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.dbroom.DBAcces;
import com.softchan.agendaescolar.dbroom.Homework;
import com.softchan.agendaescolar.dbroom.User;

import java.util.List;

public class HomeworkAdapter extends RecyclerView.Adapter<HomeworkAdapter.ViewHolder>{

    private List<Homework> homeworkDataList;
    private Activity context;

    public HomeworkAdapter(Activity context, List<Homework> homeworkDataList){
        this.context = context;
        this.homeworkDataList = homeworkDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // iniciaizar el view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_homework, parent, false);
        return new HomeworkAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // inicializar los datos principales
        Homework data = homeworkDataList.get(position);
        // visualizar el texto en el textview
        holder.asignatura.setText(data.getAsignatura());
        holder.titulo.setText(data.getTitulo());
        holder.fecha_entrega.setText(data.getFecha_entrega());
        holder.descripcion.setText(data.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return homeworkDataList.size();
    }

    public void delete(int position){
        Homework hw = homeworkDataList.get(position);
        DBAcces dbAcces = DBAcces.getInstance(context, DBAcces.optionHomeworkDAO);
        dbAcces.deleteHomework(hw);
        notifyDataSetChanged();
    }

    public Homework update(int position){
        return homeworkDataList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        TextView asignatura;
        TextView titulo;
        TextView fecha_entrega;
        TextView descripcion;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // asignacion de variables
            asignatura = itemView.findViewById(R.id.name_subject);
            titulo = itemView.findViewById(R.id.titulo);
            fecha_entrega = itemView.findViewById(R.id.fecha);
            descripcion = itemView.findViewById(R.id.descripcion);
            cardView = itemView.findViewById(R.id.cardview_hw);
            cardView.setOnCreateContextMenuListener(this);

        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(this.getAdapterPosition(),0,0,"Editar");
            menu.add(this.getAdapterPosition(),1,1,"Eliminar");
        }
    }

}
