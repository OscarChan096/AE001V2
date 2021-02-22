package com.softchan.agendaescolar.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.dbroom.Lessons;
import com.softchan.agendaescolar.dbroom.User;

import java.util.List;

public class AlumAdapter extends RecyclerView.Adapter<AlumAdapter.ViewHolder> {

    private List<User> alumDataList;
    private Activity context;

    public AlumAdapter(Activity context, List<User> alumDataList){
        this.context = context;
        this.alumDataList = alumDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_alum,parent,false);
        return new AlumAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User data = alumDataList.get(position);
        holder.numControl.setText(data.getNum_control());
        holder.nombreAlumno.setText(data.getNombreAlumno());
        holder.nombreEscuela.setText(data.getEscuela());
        holder.especialidadAlumno.setText(data.getEspecialidad());
        holder.numTelAlum.setText(data.getNum_telefono());
    }

    @Override
    public int getItemCount() {
        return alumDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView numControl;
        TextView nombreAlumno;
        TextView nombreEscuela;
        TextView especialidadAlumno;
        TextView numTelAlum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numControl = itemView.findViewById(R.id.id_user);
            nombreAlumno = itemView.findViewById(R.id.nombre_alumno);
            nombreEscuela = itemView.findViewById(R.id.nombre_escuela);
            especialidadAlumno = itemView.findViewById(R.id.especialidad_alum);
            numTelAlum = itemView.findViewById(R.id.num_alum);
        }
    }
}
