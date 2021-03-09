package com.softchan.agendaescolar.ui.tareas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.activities.AddSubject;
import com.softchan.agendaescolar.activities.AlumEdit;
import com.softchan.agendaescolar.activities.Alumno;
import com.softchan.agendaescolar.activities.HomeworkEdit;
import com.softchan.agendaescolar.adapters.HomeworkAdapter;
import com.softchan.agendaescolar.adapters.NoteAdapter;
import com.softchan.agendaescolar.dbroom.DBAcces;
import com.softchan.agendaescolar.dbroom.Homework;
import com.softchan.agendaescolar.dbroom.Note;
import com.softchan.agendaescolar.dbroom.User;

import org.jetbrains.annotations.TestOnly;

import java.util.ArrayList;
import java.util.List;

public class TareasFragment extends Fragment {

    List<Homework> homeworkDataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    DBAcces database;
    HomeworkAdapter adapter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_notas, container, false);
        recyclerView = layout.findViewById(R.id.rview_note);
        database = DBAcces.getInstance(getContext(),0); // revisar la inicializacion de la BD
        homeworkDataList = database.getAllHomework();
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new HomeworkAdapter(getActivity(), homeworkDataList);
        recyclerView.setAdapter(adapter);

        return layout;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 0:
                Homework hw = adapter.update(item.getGroupId());
                Intent update = new Intent(getContext(), HomeworkEdit.class);
                update.putExtra("id",hw.getId()+"");
                update.putExtra("asign",hw.getAsignatura());
                update.putExtra("titulo",hw.getTitulo());
                update.putExtra("fecha",hw.getFecha_entrega());
                update.putExtra("descripcion",hw.getDescripcion());
                startActivity(update);
                break;
            case 1:
                adapter.delete(item.getGroupId());
                break;
        }

        return super.onContextItemSelected(item);
    }

}