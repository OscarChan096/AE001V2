package com.softchan.agendaescolar.ui.agenda;

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

import com.softchan.agendaescolar.R;

public class AgendaFragment extends Fragment {

    /*private static final String TEXT = "text";

    public static AgendaFragment newInstance(String text) {
        AgendaFragment frag = new AgendaFragment();

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);

        return frag;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_agenda, container, false);

        ListView lv = layout.findViewById(R.id.list_agenda);

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