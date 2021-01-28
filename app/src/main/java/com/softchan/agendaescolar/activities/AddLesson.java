package com.softchan.agendaescolar.activities;

import android.os.Bundle;
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

import java.util.List;

public class AddLesson extends AppCompatActivity {

    private Spinner spinnerAsignatura;
    private EditText hora1, hora2;
    private EditText aula;
    private EditText profesor;
    private Button btnSave;
    private String sAsignatura;
    private String sHora1,sHora2;
    private String sAula;
    private String sProfesor;
    private String dia;
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
        btnSave = findViewById(R.id.btnguardar);

        spinnerAsignatura.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getSubjects()));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sAsignatura = spinnerAsignatura.getItemAtPosition(spinnerAsignatura.getSelectedItemPosition()).toString();
                sHora1 = hora1.getText().toString();
                sHora2 = hora2.getText().toString();
                sAula = aula.getText().toString();
                sProfesor = profesor.getText().toString();
                dbAcces = DBAcces.getInstance(getApplicationContext(),DBAcces.optionLessonDAO);
                String subjectId = getSubjectId(sAsignatura);
                String lessonId = createId(subjectId,dia);
                Lessons lessons = new Lessons(lessonId, dia, sAsignatura, sHora1, sHora2, sAula, sProfesor, subjectId);
                dbAcces.addLessons(lessons);
                Toast.makeText(getApplicationContext(),"Guardado",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private String getSubjectId(String sAsignatura){
        return dbAcces.findBySubjects(sAsignatura);
    }

    private String createId(String subject_id, String dia){
        return subject_id+dia;
    }

    private List<String> getSubjects(){
        dbAcces = DBAcces.getInstance(getApplicationContext(),DBAcces.optionSubjectDAO);
        return dbAcces.getAllSubjectsName();
    }

}
