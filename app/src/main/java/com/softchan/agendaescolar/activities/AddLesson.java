package com.softchan.agendaescolar.activities;

import android.content.Intent;
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
import com.softchan.agendaescolar.dbroom.Lessons;
import com.softchan.agendaescolar.dbroom.Subjects;

import java.util.ArrayList;
import java.util.List;

public class AddLesson extends AppCompatActivity {

    private Spinner spinnerAsignatura;
    private EditText hora1, hora2;
    private EditText aula;
    private EditText profesor;
    private String sAsignatura;
    private String sHora1,sHora2;
    private String sAula;
    private String sProfesor;
    private int dia;
    private DBAcces dbAcces;

    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.app_bar_addlessons);

        Toolbar toolbar = findViewById(R.id.toolbar_addlessons);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        dia = Integer.parseInt(i.getStringExtra("dia"));

        spinnerAsignatura = findViewById(R.id.spinnerlessons);
        hora1 = findViewById(R.id.hora_empiezo);
        hora2 = findViewById(R.id.hora_fin);
        aula = findViewById(R.id.aula);
        profesor = findViewById(R.id.profesor);

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
                sHora1 = hora1.getText().toString();
                sHora2 = hora2.getText().toString();
                sAula = aula.getText().toString();
                sProfesor = profesor.getText().toString();
                dbAcces = DBAcces.getInstance(getApplicationContext(),DBAcces.optionLessonDAO);
                Lessons lessons = new Lessons(dia, sAsignatura, sHora1, sHora2, sAula, sProfesor);
                dbAcces.addLessons(lessons);
                Toast.makeText(getApplicationContext(),"Guardado",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private List<Subjects> getSubjectId(String sAsignatura){
        return dbAcces.findBySubjects(sAsignatura);
    }

    private String createId(String subject_id, int dia){
        return subject_id+dia;
    }

    private List<String> getSubjects(){
        List<String> subjectList = new ArrayList<>();
        dbAcces = DBAcces.getInstance(getApplicationContext(), DBAcces.optionSubjectDAO);

        for(Subjects subjects : dbAcces.getAllSubjectsName()) {
            //Log.d("metodo getSubjects",subjects.getNameSubject()+""+subjects.getSubjectId());
            subjectList.add(subjects.getNameSubject());
        }

        return subjectList;
    }

}
