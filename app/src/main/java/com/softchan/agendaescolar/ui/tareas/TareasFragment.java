package com.softchan.agendaescolar.ui.tareas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.adapters.HomeworkAdapter;
import com.softchan.agendaescolar.adapters.NoteAdapter;
import com.softchan.agendaescolar.dbroom.DBAcces;
import com.softchan.agendaescolar.dbroom.Homework;
import com.softchan.agendaescolar.dbroom.Note;

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

        //if (getArguments() != null) {
        //((TextView) layout.findViewById(R.id.text_home)).setText(getArguments().getString(TEXT));
        //}

        return layout;
    }
}