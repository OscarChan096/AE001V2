package com.softchan.agendaescolar.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.activities.AddHomework;
import com.softchan.agendaescolar.activities.AddNotes;
import com.softchan.agendaescolar.activities.AddSubject;

public class AddOptionDialog extends DialogFragment {

    public AddOptionDialog() {}

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return createLoginDialogo();
    }

    public AlertDialog createLoginDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //builder.setTitle("NUEVO");

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.addoptiondialog, null);

        builder.setView(v);

        TextView addAsign = v.findViewById(R.id.addasign);
        TextView addTarea = v.findViewById(R.id.addhw);
        TextView addNota = v.findViewById(R.id.addnota);

        addAsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iAddAsign = new Intent(getActivity(), AddSubject.class);
                startActivity(iAddAsign);
            }
        });

        addTarea.setOnClickListener(v1 -> {
            Intent iAddTarea = new Intent(getActivity(), AddHomework.class);
            startActivity(iAddTarea);
        });

        addNota.setOnClickListener(v1 ->{
            Intent iAddNota = new Intent(getActivity(), AddNotes.class);
            startActivity(iAddNota);
        });

        return builder.create();
    }


}
