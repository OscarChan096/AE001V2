package com.softchan.agendaescolar.dbroom.Interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.softchan.agendaescolar.dbroom.Note;

import java.util.List;

@Dao
public interface NoteDAO {

    @Query("SELECT nota FROM notas")
    List<Note> getNotes();

    @Insert
    void add(Note note);

    @Delete
    void delete(Note note);

    @Update
    void update(Note note);

}
