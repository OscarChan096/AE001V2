package com.softchan.agendaescolar.dbroom.Interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.softchan.agendaescolar.dbroom.Homework;

import java.util.List;

@Dao
public interface HomeworkDAO {

    @Query("SELECT * FROM homework")
    List<Homework> getAll();

    @Query("SELECT * FROM homework WHERE tarea_id = :id")
    List<Homework> getById(int id);

    @Query("SELECT titulo FROM homework WHERE titulo LIKE :titulo")
    Homework findByTitle(String titulo);

    // obtener fecha de entrega

    @Insert
    void add(Homework homework);

    @Delete
    void delete(Homework homework);

    @Update
    void update(Homework homework);

}
