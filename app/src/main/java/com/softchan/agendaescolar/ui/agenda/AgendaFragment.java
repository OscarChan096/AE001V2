package com.softchan.agendaescolar.ui.agenda;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.adapters.AgendaAdapter;
import com.softchan.agendaescolar.config.AgendaInfo;
import com.softchan.agendaescolar.dbroom.Agenda;

import java.util.ArrayList;
import java.util.List;

public class AgendaFragment extends Fragment {

    private RecyclerView rvH;
    private RecyclerView rvM;
    private AgendaAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_agenda, container, false);

        List<Agenda> agendaList = new ArrayList<>();
        //agendaList.add(new Agenda("asign","test","fecha","descripcion",0));
        //agendaList.add(new Agenda("asign2","test2","fecha2","descripcion2",0));
        //agendaList.add(new Agenda(2,"asign","name","10","aula",1));
        //agendaList.add(new Agenda(2,"asign2","name2","20","aula2",1));

        //List<Agenda> agendaList = AgendaInfo.getListAgendaH(getActivity());

        rvH = layout.findViewById(R.id.rviewh);
        linearLayoutManager = new LinearLayoutManager(getContext());
        rvH.setLayoutManager(linearLayoutManager);
        adapter = new AgendaAdapter(getActivity(), agendaList);
        rvH.setAdapter(adapter);

        //rvM = layout.findViewById(R.id.rviewm);
        //rvM.setLayoutManager(linearLayoutManager);
        //adapter = new AgendaAdapter(getActivity(),AgendaInfo.getListAgendaM(getActivity()));
        //rvM.setAdapter(adapter);

        return layout;
    }

}