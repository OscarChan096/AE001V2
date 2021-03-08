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

    @Update
    void update(User user);

}
