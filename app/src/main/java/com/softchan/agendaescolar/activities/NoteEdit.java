package com.softchan.agendaescolar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.dbroom.DBAcces;
import com.softchan.agendaescolar.dbroom.Note;

public class NoteEdit extends AppCompatActivity {

    private EditText notes;

    private String sNote;

    private int id;

    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.app_bar_addnotes);

        Toolbar toolbar = findViewById(R.id.toolbar_addnotes);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);

        notes = findViewById(R.id.edt_notes);

        Intent i = getIntent();
        id = Integer.parseInt(i.getStringExtra("id"));
        sNote = i.getStringExtra("note");

        notes.setText(sNote);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case R.id.action_save:
                sNote = notes.getText().toString();
                if (sNote.length() > 0) {
                    DBAcces dbAcces = DBAcces.getInstance(getApplicationContext(), DBAcces.optionNoteDAO);
                    dbAcces.updateNote(id,sNote);
                    Toast.makeText(getApplicationContext(),"Actualizado",Toast.LENGTH_SHORT).show();
                    notes.setText("");
                }else if(sNote.equals("")){
                    Toast.makeText(getApplicationContext(),"Nota vacia: ingrese texto",Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
