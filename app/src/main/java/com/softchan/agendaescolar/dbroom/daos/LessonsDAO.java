package com.softchan.agendaescolar.dbroom.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.softchan.agendaescolar.dbroom.Lessons;

import java.util.List;

@Dao
public interface LessonsDAO {

    @Query("SELECT * FROM lessons")
    List<Lessons> getAll();

    @Query("SELECT * FROM lessons WHERE dia=:dia")
    List<Lessons> getByDia(int dia);

    @Insert
    void add(Lessons lessons);

    @Delete
    void delete(Lessons lessons);

    @Query("UPDATE lessons SET name_subject=:asignatura, name_professor=:profesor, hora_empiezo=:h1, hora_fin=:h2, aula=:aula WHERE id=:id")
    void update(int id, String asignatura, String profesor, String h1, String h2, String aula);

}
