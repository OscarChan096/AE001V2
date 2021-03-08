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
import com.softchan.agendaescolar.dbroom.User;

public class AddUser extends AppCompatActivity {

    private String sNumControl;
    private String sNombreUsuario;
    private String sEscuela;
    private String sEspecialidad;
    private String sNumTelefono;

    private int iNumTelefono;

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

        EditText num_control = findViewById(R.id.edt_id);
        EditText nombre_usuario = findViewById(R.id.edt_name_user);
        EditText escuela = findViewById(R.id.edt_name_school);
        EditText especialidad = findViewById(R.id.edt_especialidad);
        EditText num_telefono = findViewById(R.id.edt_number_phone);

        sNumControl = num_control.getText().toString();
        sNombreUsuario = nombre_usuario.getText().toString();
        sEscuela = escuela.getText().toString();
        sEspecialidad = especialidad.getText().toString();
        sNumTelefono = num_telefono.getText().toString();

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
                dbAcces = DBAcces.getInstance(getApplicationContext(), DBAcces.optionUserDAO);
                sNumControl = (sNumControl.length() > 0) ?sNumControl:generateId();
                sNombreUsuario = (sNombreUsuario.length() > 0)?sNombreUsuario:"S/E";
                sEscuela = (sEscuela.length() > 0)?sEscuela:"S/E";
                sEspecialidad = (sEspecialidad.length() > 0)?sEspecialidad:"S/E";
                iNumTelefono = Integer.parseInt(sNumTelefono);
                User user = new User(sNombreUsuario, sEscuela, sEspecialidad, iNumTelefono, sNumControl);
                dbAcces.addUser(user);
                Toast.makeText(getApplicationContext(),"Guardado", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private String generateId(){
        int id = (int) (Math.random()*10)+1;
        return String.valueOf(id);
    }


}
