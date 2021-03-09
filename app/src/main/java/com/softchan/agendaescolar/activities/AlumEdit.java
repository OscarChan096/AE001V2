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
import com.softchan.agendaescolar.dbroom.User;

public class AlumEdit extends AppCompatActivity {

    private String sNumControl;
    private String sNombreAlumno;
    private String sEscuela;
    private String sEspecialidad;
    private String sNumTelefono;
    private String sId;

    private EditText num_control;
    private EditText nombre_usuario;
    private EditText escuela;
    private EditText especialidad;
    private EditText num_telefono;

    private DBAcces dbAcces;

    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.app_bar_addalum);
        Toolbar toolbar = findViewById(R.id.toolbar_addalumn);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);

        num_control = findViewById(R.id.edt_id);
        nombre_usuario = findViewById(R.id.edt_name_user);
        escuela = findViewById(R.id.edt_name_school);
        especialidad = findViewById(R.id.edt_especialidad);
        num_telefono = findViewById(R.id.edt_number_phone);

        Intent i = getIntent();
        sId = i.getStringExtra("id");
        sNumControl = i.getStringExtra("numc");
        sNombreAlumno = i.getStringExtra("nombre");
        sEscuela = i.getStringExtra("escuela");
        sEspecialidad = i.getStringExtra("especialidad");
        sNumTelefono = i.getStringExtra("numt");

        num_control.setText(sNumControl);
        nombre_usuario.setText(sNombreAlumno);
        escuela.setText(sEscuela);
        especialidad.setText(sEspecialidad);
        num_telefono.setText(sNumTelefono);

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
                sNumControl = num_control.getText().toString();
                sNombreAlumno = nombre_usuario.getText().toString();
                sEscuela = escuela.getText().toString();
                sEspecialidad = especialidad.getText().toString();
                sNumTelefono = num_telefono.getText().toString();
                sNumControl = (sNumControl.length() > 0) ?sNumControl:"S/E";
                sNombreAlumno = (sNombreAlumno.length() > 0)?sNombreAlumno:"S/E";
                sEscuela = (sEscuela.length() > 0)?sEscuela:"S/E";
                sEspecialidad = (sEspecialidad.length() > 0)?sEspecialidad:"S/E";
                dbAcces = DBAcces.getInstance(getApplicationContext(), DBAcces.optionUserDAO);
                dbAcces.updateUser(Integer.parseInt(sId),sNombreAlumno,sEscuela,sEspecialidad,generateIntegerNumTelefono(sNumTelefono),sNumControl);
                Toast.makeText(getApplicationContext(),"Guardado", Toast.LENGTH_SHORT).show();
                num_control.setText("");
                nombre_usuario.setText("");
                escuela.setText("");
                especialidad.setText("");
                num_telefono.setText("");
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private int generateIntegerNumTelefono(String num){
        int iNumTelefono;
        if (num.length() > 0)
            iNumTelefono = Integer.parseInt(num);
        else
            iNumTelefono = 0;

        return iNumTelefono;
    }

}
