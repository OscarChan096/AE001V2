package com.softchan.agendaescolar.dbroom.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.softchan.agendaescolar.dbroom.Subjects;

import java.util.List;

@Dao
public interface SubjectsDAO {

    @Query("SELECT * FROM subjects")
    List<Subjects> getAll();

    @Query("SELECT name_subject FROM subjects")
    List<String> getAllSubjects();

    @Query("SELECT * FROM subjects WHERE subject_id LIKE :id")
    Subjects getSubjectById(String id);

    @Query("SELECT subject_id FROM subjects WHERE name_subject LIKE :name_subject")
    String findBySubject(String name_subject);

    @Query("SELECT subject_id,name_professor FROM subjects WHERE name_professor LIKE :name")
    Subjects findByName(String name);

    @Insert
    void add(Subjects subjects);

    @Delete
    void delete(Subjects subjects);

    @Update
    void update(Subjects subjects);

}
