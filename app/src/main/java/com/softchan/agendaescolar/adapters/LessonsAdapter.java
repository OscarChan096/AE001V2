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
import com.softchan.agendaescolar.dbroom.Lessons;
import com.softchan.agendaescolar.dbroom.User;

import java.util.List;

public class LessonsAdapter extends RecyclerView.Adapter<LessonsAdapter.ViewHolder> {

    private List<Lessons> lessonDataList;
    private Activity context;

    public LessonsAdapter(Activity context, List<Lessons> lessonDataList){
        this.context = context;
        this.lessonDataList = lessonDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_lessons,parent,false);
        return new LessonsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lessons data = lessonDataList.get(position);
        holder.asigntura.setText(data.getNameSubject());
        holder.hora_empiezo.setText(data.getHoraEmpiezo());
        holder.hora_fin.setText(data.getHoraFin());
        //holder.hora_empiezo.setText(data.getHora());
        holder.aula.setText(data.getAula());
        holder.profesor.setText(data.getNameProfessor());
    }

    @Override
    public int getItemCount() {
        return lessonDataList.size();
    }

    public void delete(int position){
        Lessons lessons = lessonDataList.get(position);
        DBAcces dbAcces = DBAcces.getInstance(context, DBAcces.optionLessonDAO);
        dbAcces.deleteLessons(lessons);
        notifyDataSetChanged();
    }

    public Lessons update(int position){
        return lessonDataList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        TextView asigntura;
        TextView hora_empiezo;
        TextView hora_fin;
        TextView aula;
        TextView profesor;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            asigntura = itemView.findViewById(R.id.name_subject);
            hora_empiezo = itemView.findViewById(R.id.hora_empiezo);
            hora_fin = itemView.findViewById(R.id.hora_fin);
            aula = itemView.findViewById(R.id.aula);
            profesor = itemView.findViewById(R.id.profesor);
            cardView = itemView.findViewById(R.id.cardview_lessons);
            cardView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(this.getAdapterPosition(),0,0,"Editar");
            menu.add(this.getAdapterPosition(),1,1,"Eliminar");
        }
    }
}
