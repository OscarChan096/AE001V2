package com.softchan.agendaescolar.activities;

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
import com.softchan.agendaescolar.dbroom.Subjects;

public class AddSubject extends AppCompatActivity {

    private String sAsignatura;
    private String sProfesor;
    private String sAula;
    private EditText asignatura;
    private EditText profesor;
    private EditText aula;

    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.app_bar_addsubject);
        Toolbar toolbar = findViewById(R.id.toolbar_addsubject);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);

        asignatura = findViewById(R.id.edt_name_subject);
        profesor = findViewById(R.id.edt_profesor);
        aula = findViewById(R.id.edt_aula);

        sAsignatura = asignatura.getText().toString();
        sProfesor = profesor.getText().toString();
        sAula = aula.getText().toString();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_addsubject, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case R.id.action_save:
                if (sAsignatura.equals("")) {
                    Toast.makeText(getApplicationContext(), "Asignatura esta vacio", Toast.LENGTH_SHORT).show();
                }else {
                    sProfesor = (sProfesor.equals(""))?"Sin especificar":sProfesor;
                    sAula = (sAula.equals(""))?"Sin especificar":sAula;
                    Subjects subjects = new Subjects(createId(sAsignatura),sAsignatura,sProfesor,sAula);
                    DBAcces dbAcces = DBAcces.getInstance(getApplicationContext(),2);
                    dbAcces.addSubjects(subjects);
                    Toast.makeText(getApplicationContext(),"Guardado",Toast.LENGTH_SHORT).show();
                    asignatura.setText("");
                    profesor.setText("");
                    aula.setText("");
                }
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private String createId(String sAsignatura){
        int random = (int) (Math.random()*50)+1;
        return sAsignatura.substring(0,2)+random;
    }

}
