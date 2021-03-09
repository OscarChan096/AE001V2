package com.softchan.agendaescolar.dbroom.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.softchan.agendaescolar.dbroom.Note;

import java.util.List;

@Dao
public interface NoteDAO {

    @Query("SELECT id,nota FROM notas")
    List<Note> getNotes();

    @Insert
    void add(Note note);

    @Delete
    void delete(Note note);

    @Query("UPDATE notas SET nota=:note WHERE id=:id")
    void update(int id,String note);

}
