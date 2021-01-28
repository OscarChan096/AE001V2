package com.softchan.agendaescolar.activities;

import android.os.Bundle;
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
    private Button btnSave;
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
        btnSave = findViewById(R.id.btnguardar);

        spinnerAsignatura.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getSubjects()));

        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                sAsignatura = spinnerAsignatura.getItemAtPosition(spinnerAsignatura.getSelectedItemPosition()).toString();
                sTitulo = titulo.getText().toString();
                sFechaEntrega = fechaEntrega.getText().toString();
                sDescripcion = descripcion.getText().toString();
                dbAcces = DBAcces.getInstance(getApplicationContext(),0);
                Homework hw = new Homework(sAsignatura, sTitulo, sFechaEntrega, sDescripcion);
                dbAcces.addHomework(hw);
                Toast.makeText(getApplicationContext(),"Guardado",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private List<String> getSubjects(){
        dbAcces = DBAcces.getInstance(getApplicationContext(), 2);
        return dbAcces.getAllSubjectsName();
    }

}
