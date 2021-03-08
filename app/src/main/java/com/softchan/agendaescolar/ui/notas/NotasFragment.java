package com.softchan.agendaescolar.ui.notas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.adapters.NoteAdapter;
import com.softchan.agendaescolar.dbroom.DBAcces;
import com.softchan.agendaescolar.dbroom.Note;

import java.util.ArrayList;
import java.util.List;

public class NotasFragment extends Fragment {

    private List<Note> notesDataList = new ArrayList<>();
    private DBAcces database;
    private NoteAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_notas, container, false);

        recyclerView = layout.findViewById(R.id.rview_note);
        database = DBAcces.getInstance(getContext(),DBAcces.optionNoteDAO);
        notesDataList = database.getNotes();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new NoteAdapter(getActivity(), notesDataList);
        recyclerView.setAdapter(adapter);

        return layout;
    }
}