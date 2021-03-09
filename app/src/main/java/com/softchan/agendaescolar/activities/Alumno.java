package com.softchan.agendaescolar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.adapters.AlumAdapter;
import com.softchan.agendaescolar.adapters.LessonsAdapter;
import com.softchan.agendaescolar.dbroom.DBAcces;
import com.softchan.agendaescolar.dbroom.Lessons;
import com.softchan.agendaescolar.dbroom.User;

import java.util.List;

public class Alumno extends AppCompatActivity {

    private List<User> listAlumInfo;
    private AlumAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.app_bar_alum);
        Toolbar toolbar = findViewById(R.id.toolbar_user);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);

        DBAcces dbAcces = DBAcces.getInstance(getApplicationContext(),DBAcces.optionUserDAO);
        listAlumInfo = dbAcces.getUser();

        recyclerView = findViewById(R.id.rview_user);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new AlumAdapter(getParent(),listAlumInfo);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case R.id.action_new:
                Intent addAlum = new Intent(getApplicationContext(), AddAlum.class);
                startActivity(addAlum);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 0:
                User user = adapter.update(item.getGroupId());
                Intent update = new Intent(getApplicationContext(), AlumEdit.class);
                update.putExtra("id",user.getId()+"");
                update.putExtra("numc",user.getNum_control());
                update.putExtra("nombre",user.getNombreAlumno());
                update.putExtra("escuela",user.getEscuela());
                update.putExtra("especialidad",user.getEspecialidad());
                update.putExtra("numt",user.getNum_telefono()+"");
                startActivity(update);
                break;
            case 1:
                adapter.delete(item.getGroupId());
                break;
        }

        return super.onContextItemSelected(item);
    }
}
