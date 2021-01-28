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

    @Query("SELECT dia FROM lessons WHERE dia LIKE :dia")
    List<Lessons> getByDia(String dia);

    @Insert
    void add(Lessons lessons);

    @Delete
    void delete(Lessons lessons);

    @Update
    void update(Lessons lessons);

}
