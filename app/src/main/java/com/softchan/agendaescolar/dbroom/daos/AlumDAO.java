package com.softchan.agendaescolar.dbroom.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.softchan.agendaescolar.dbroom.User;

import java.util.List;

@Dao
public interface AlumDAO {

    @Query("SELECT * FROM user")
    List<User> getUser();

    @Insert
    void add(User user);

    @Delete
    void delete(User user);

    @Query("UPDATE user SET num_control=:num_control, nombre_alumno=:nombre_alumno, escuela=:escuela, especialidad=:especialidad, num_telefono=:num_telefono WHERE id=:id")
    void update(int id, String nombre_alumno, String escuela, String especialidad, int num_telefono, String num_control);

}
