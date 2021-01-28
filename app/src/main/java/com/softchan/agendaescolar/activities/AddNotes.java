package com.softchan.agendaescolar.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.dbroom.DBAcces;
import com.softchan.agendaescolar.dbroom.Note;

public class AddNotes extends AppCompatActivity {

    private EditText notes;

    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.app_bar_addnotes);
        Toolbar toolbar = findViewById(R.id.toolbar_addsubject);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);

        notes = findViewById(R.id.edt_notes);
        String sNote = notes.getText().toString();
        Button save = findViewById(R.id.savenote);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sNote.length() > 0) {
                    DBAcces dbAcces = DBAcces.getInstance(getApplicationContext(), 3);
                    Note note = new Note(sNote);
                    dbAcces.addNotes(note);
                    Toast.makeText(getApplicationContext(),"Guardado",Toast.LENGTH_SHORT).show();
                    notes.setText("");
                }else if(sNote.equals("")){
                    Toast.makeText(getApplicationContext(),"Nota vacia, ingrese texto",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
