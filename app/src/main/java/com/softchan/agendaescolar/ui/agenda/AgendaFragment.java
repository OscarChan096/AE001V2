package com.softchan.agendaescolar.ui.agenda;

import android.os.Bundle;
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
import com.softchan.agendaescolar.dbroom.DBAcces;

public class AgendaFragment extends Fragment {

    /*private static final String TEXT = "text";

    public static AgendaFragment newInstance(String text) {
        AgendaFragment frag = new AgendaFragment();

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);

        return frag;
    }*/

    private DBAcces dbAcces;
    private RecyclerView rvH;
    private RecyclerView rvM;
    private AgendaAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_agenda, container, false);

        rvH = layout.findViewById(R.id.rviewh);
        linearLayoutManager = new LinearLayoutManager(getContext());
        rvH.setLayoutManager(linearLayoutManager);
        adapter = new AgendaAdapter(getActivity(), AgendaInfo.getListAgendaH(getActivity()));
        rvH.setAdapter(adapter);

        rvM = layout.findViewById(R.id.rviewm);
        rvM.setLayoutManager(linearLayoutManager);
        adapter = new AgendaAdapter(getActivity(),AgendaInfo.getListAgendaM(getActivity()));
        rvM.setAdapter(adapter);

        //if (getArguments() != null) {
            //((TextView) layout.findViewById(R.id.text_home)).setText(getArguments().getString(TEXT));
        //}

        return layout;
    }

    /*private AgendaViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(AgendaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_agenda, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }*/
}