package com.softchan.agendaescolar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softchan.agendaescolar.R;
import com.softchan.agendaescolar.adapters.LessonsAdapter;
import com.softchan.agendaescolar.dbroom.DBAcces;
import com.softchan.agendaescolar.dbroom.Lessons;

import java.util.List;

public class LessonsDays extends AppCompatActivity {

    private DBAcces dbAcces;
    private List<Lessons> listLessons;
    private LinearLayoutManager linearLayoutManager;
    private LessonsAdapter adapter;
    private RecyclerView recyclerView;
    private String dia;

    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.app_bar_lessons);

        Toolbar toolbar = findViewById(R.id.toolbar_lessons);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);

        dbAcces = DBAcces.getInstance(getApplicationContext(),DBAcces.optionLessonDAO);

        Intent intent = getIntent();
        dia = intent.getStringExtra("dia");

        listLessons = dbAcces.getByDia(Integer.parseInt(dia));

        recyclerView = findViewById(R.id.rview_lessons);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new LessonsAdapter(getParent(),listLessons);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_lessons_to_day, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case R.id.action_addlessons:
                Intent actionNew = new Intent(getApplicationContext(), AddLesson.class);
                actionNew.putExtra("dia",dia);
                startActivity(actionNew);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
