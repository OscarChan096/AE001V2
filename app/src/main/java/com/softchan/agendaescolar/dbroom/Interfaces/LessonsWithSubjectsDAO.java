package com.softchan.agendaescolar.dbroom.Interfaces;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.softchan.agendaescolar.dbroom.LessonsWithSubjects;

import java.util.List;

@Dao
public interface LessonsWithSubjectsDAO {

    @Transaction
    @Query("SELECT * FROM lessons")
    public List<LessonsWithSubjects> getLessonsWithSubjects();

}
