package com.softchan.agendaescolar.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;
import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.dbroom.DBAcces;
import com.softchan.agendaescolar.dbroom.User;

public class AddAlum extends AppCompatActivity {

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
                String sNumControl = num_control.getText().toString();
                String sNombreUsuario = nombre_usuario.getText().toString();
                String sEscuela = escuela.getText().toString();
                String sEspecialidad = especialidad.getText().toString();
                String sNumTelefono = num_telefono.getText().toString();
                sNumControl = (sNumControl.length() > 0) ?sNumControl:"S/E";
                sNombreUsuario = (sNombreUsuario.length() > 0)?sNombreUsuario:"S/E";
                sEscuela = (sEscuela.length() > 0)?sEscuela:"S/E";
                sEspecialidad = (sEspecialidad.length() > 0)?sEspecialidad:"S/E";
                User user = new User(sNombreUsuario, sEscuela, sEspecialidad, generateIntegerNumTelefono(sNumTelefono), sNumControl);
                dbAcces = DBAcces.getInstance(getApplicationContext(), DBAcces.optionUserDAO);
                dbAcces.addUser(user);
                Snackbar.make(findViewById(android.R.id.content),"Añadido", Snackbar.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),"Guardado", Toast.LENGTH_SHORT).show();
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
        if (num.length() > 0)
            return Integer.parseInt(num);
        else
            return 0;
    }


}
