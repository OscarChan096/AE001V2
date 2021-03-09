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

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_agenda, container, false);

        List<Agenda> agendaList = AgendaInfo.getListAgendaH(getActivity());

        rvH = layout.findViewById(R.id.rviewh);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvH.setLayoutManager(linearLayoutManager);
        adapter = new AgendaAdapter(getActivity(), agendaList);
        rvH.setAdapter(adapter);

        rvM = layout.findViewById(R.id.rviewm);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        rvM.setLayoutManager(linearLayoutManager1);
        adapter = new AgendaAdapter(getActivity(),AgendaInfo.getListAgendaT(getActivity()));
        rvM.setAdapter(adapter);

        return layout;
    }

}