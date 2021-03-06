package com.softchan.agendaescolar.dbroom.daos;

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

    @Query("SELECT * FROM homework WHERE id = :id")
    List<Homework> getById(int id);

    @Insert
    void add(Homework homework);

    @Delete
    void delete(Homework homework);

    @Query("UPDATE homework SET asignatura=:asign,titulo=:titulo,fecha_entrega=:fecha,descripcion=:descripcion WHERE id=:id")
    void update(int id, String asign, String titulo, String fecha, String descripcion);

}
