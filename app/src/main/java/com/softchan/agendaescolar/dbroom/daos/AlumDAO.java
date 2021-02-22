package com.softchan.agendaescolar.dbroom.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.softchan.agendaescolar.dbroom.User;

@Dao
public interface AlumDAO {

    @Query("SELECT * FROM user")
    User getUser();

    @Insert
    void add(User user);

    @Delete
    void delete(User user);

    @Update
    void update(User user);

}
