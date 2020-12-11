package com.softchan.agendaescolar.dbroom.Interfaces;

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

    @Query("SELECT * FROM subjects WHERE subject_id LIKE :id")
    Subjects getSubjectById(String id);

    @Query("SELECT name_subject FROM subjects WHERE name_subject LIKE :name_subject")
    Subjects findBySubject(String name_subject);

    @Query("SELECT first_name_professor FROM subjects WHERE first_name_professor LIKE :firstname")
    Subjects findByFirstName(String firstname);

    @Query("SELECT last_name_professor FROM subjects WHERE last_name_professor LIKE :lastname")
    Subjects findByLastName(String lastname);

    @Insert
    void add(Subjects subjects);

    @Delete
    void delete(Subjects subjects);

    @Update
    void update(Subjects subjects);

}
