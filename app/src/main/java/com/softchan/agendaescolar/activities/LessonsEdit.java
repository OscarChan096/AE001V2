package com.softchan.agendaescolar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.dbroom.DBAcces;
import com.softchan.agendaescolar.dbroom.Lessons;
import com.softchan.agendaescolar.dbroom.Subjects;

import java.util.ArrayList;
import java.util.List;

public class LessonsEdit extends AppCompatActivity {

    private Spinner spinnerAsignatura;
    private EditText hora1, hora2;
    private EditText aula;
    private EditText profesor;

    private String sAsignatura;
    private String sHora1,sHora2;
    private String sAula;
    private String sProfesor;

    //private int dia;
    private int id;
    //private int categoria;
    private int spinnerPosition;

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

        spinnerAsignatura = findViewById(R.id.spinnerlessons);
        hora1 = findViewById(R.id.hora_empiezo);
        hora2 = findViewById(R.id.hora_fin);
        aula = findViewById(R.id.aula);
        profesor = findViewById(R.id.profesor);

        Intent i = getIntent();
        id = Integer.parseInt(i.getStringExtra("id"));
        //dia = Integer.parseInt(i.getStringExtra("dia"));
        sAsignatura = i.getStringExtra("asign");
        sProfesor = i.getStringExtra("profesor");
        sHora1 = i.getStringExtra("horae");
        sHora2 = i.getStringExtra("horaf");
        sAula = i.getStringExtra("aula");
        //categoria = Integer.parseInt(i.getStringExtra("categoria"));

        List<String> asignList = getSubjects();
        for (int index = 0; index < asignList.size(); index++){
            if (asignList.get(index).equals(sAsignatura))
                spinnerPosition = index;
        }
        spinnerAsignatura.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, asignList));
        spinnerAsignatura.setId(spinnerPosition);

        hora1.setText(sHora1);
        hora2.setText(sHora2);
        profesor.setText(sProfesor);
        aula.setText(sAula);

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
                dbAcces.updateLessons(id,sAsignatura,sProfesor,sHora1,sHora2,sAula);
                Toast.makeText(getApplicationContext(),"Guardado",Toast.LENGTH_SHORT).show();
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
