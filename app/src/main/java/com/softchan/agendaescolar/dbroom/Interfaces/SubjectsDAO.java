package com.softchan.agendaescolar.dbroom.Interfaces;

import androidx.room.Dao;
import androidx.room.Query;

import com.softchan.agendaescolar.dbroom.Subjects;

import java.util.List;

@Dao
public interface SubjectsDAO {
    @Query("SELECT * FROM subjects WHERE subject_id=:id")
    List<Subjects> getSubjectById(String id);
}
