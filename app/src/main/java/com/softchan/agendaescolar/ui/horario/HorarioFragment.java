package com.softchan.agendaescolar.ui.horario;

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

public class HorarioFragment extends Fragment {

    private HorarioViewModel horarioViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        horarioViewModel =
                new ViewModelProvider(this).get(HorarioViewModel.class);
        View root = inflater.inflate(R.layout.fragment_horario, container, false);
        final TextView textView = root.findViewById(R.id.text_horario);
        horarioViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}