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

import com.softchan.agendaescolar.R;

public class TareasFragment extends Fragment {

    private Tareas tareas;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tareas =
                new ViewModelProvider(this).get(Tareas.class);
        View root = inflater.inflate(R.layout.fragment_tareas, container, false);
        final TextView textView = root.findViewById(R.id.text_tareas);
        tareas.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}