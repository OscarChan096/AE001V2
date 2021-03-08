package com.softchan.agendaescolar.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.dbroom.DBAcces;
import com.softchan.agendaescolar.dbroom.Homework;
import com.softchan.agendaescolar.dbroom.Subjects;

import java.util.ArrayList;
import java.util.List;

public class AddHomework extends AppCompatActivity {

    private String sAsignatura;
    private String sTitulo;
    private String sFechaEntrega;
    private String sDescripcion;
    private Spinner spinnerAsignatura;
    private EditText fechaEntrega;
    private EditText descripcion;
    private EditText titulo;
    private DBAcces dbAcces;

    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.app_bar_addhomework);
        Toolbar toolbar = findViewById(R.id.toolbar_addhomework);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);

        spinnerAsignatura = findViewById(R.id.spinner);
        titulo = findViewById(R.id.titulo);
        fechaEntrega = findViewById(R.id.fechaEntrega);
        descripcion = findViewById(R.id.descripcion);

        List<String> asignList = getSubjects();

        if (asignList.size() > 0) {
            spinnerAsignatura.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, asignList));
        }else {
            List<String> empty = new ArrayList<>();
            empty.add("SIN ASIGNATURAS");
            spinnerAsignatura.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getSubjects()));
        }
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
                sAsignatura = spinnerAsignatura.getItemAtPosition(spinnerAsignatura.getSelectedItemPosition()).toString();
                sTitulo = titulo.getText().toString();
                sFechaEntrega = fechaEntrega.getText().toString();
                sDescripcion = descripcion.getText().toString();
                Homework hw = new Homework(sAsignatura, sTitulo, sFechaEntrega, sDescripcion);
                dbAcces = DBAcces.getInstance(getApplicationContext(),DBAcces.optionHomeworkDAO);
                dbAcces.addHomework(hw);
                Toast.makeText(getApplicationContext(),"Guardado",Toast.LENGTH_SHORT).show();
                titulo.setText("");
                fechaEntrega.setText("");
                descripcion.setText("");
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private List<String> getSubjects(){
        List<String> subjectList = new ArrayList<>();
        dbAcces = DBAcces.getInstance(getApplicationContext(), DBAcces.optionSubjectDAO);

        for(Subjects subjects : dbAcces.getAllSubjectsName()) {
            Log.d("metodo getSubjects",subjects.getNameSubject()+""+subjects.getSubjectId());
            subjectList.add(subjects.getNameSubject());
        }

        return subjectList;
    }

}
