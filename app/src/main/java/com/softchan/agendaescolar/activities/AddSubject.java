package com.softchan.agendaescolar.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.softchan.agendaescolar.R;

public class AddSubject extends AppCompatActivity {

    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.app_bar_addsubject);
        Toolbar toolbar = findViewById(R.id.toolbar_addsubject);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);
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
                Toast.makeText(getApplicationContext(),"sin Funcion - guardara los datos de la asignatura",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
