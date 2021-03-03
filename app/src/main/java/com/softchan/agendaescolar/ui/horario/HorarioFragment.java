package com.softchan.agendaescolar.ui.horario;

import android.content.Intent;
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

import com.softchan.agendaescolar.MainActivity;
import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.activities.LessonsDays;
import com.softchan.agendaescolar.adapters.NoteAdapter;
import com.softchan.agendaescolar.dbroom.DBAcces;

public class HorarioFragment extends Fragment implements View.OnClickListener {

    private TextView lunes;
    private TextView martes;
    private TextView miercoles;
    private TextView jueves;
    private TextView viernes;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_horario, container, false);

        lunes = layout.findViewById(R.id.lunes);
        martes = layout.findViewById(R.id.martes);
        miercoles = layout.findViewById(R.id.miercoles);
        jueves = layout.findViewById(R.id.jueves);
        viernes = layout.findViewById(R.id.viernes);

        lunes.setOnClickListener(this);
        martes.setOnClickListener(this);
        miercoles.setOnClickListener(this);
        jueves.setOnClickListener(this);
        viernes.setOnClickListener(this);

        return layout;
    }

    @Override
    public void onClick(View v) {
        int index = v.getId();
        switch (index){
            case R.id.lunes:
                Intent lun = new Intent(getActivity(), LessonsDays.class);
                lun.putExtra("dia","2");
                break;
            case R.id.martes:
                break;
            case R.id.miercoles:
                break;
            case R.id.jueves:
                break;
            case R.id.viernes:
                break;
        }
    }

    /*private HorarioViewModel horarioViewModel;

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
    }*/
}