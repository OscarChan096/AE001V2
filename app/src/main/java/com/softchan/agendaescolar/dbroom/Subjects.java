package com.softchan.agendaescolar.dbroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "subjects")
public class Subjects {

    @NonNull
    @PrimaryKey
    public String subject_id; // se crea con las 3 primeras letras del nombre de la asignatura y el nombre del docente

    @ColumnInfo(name = "name_subject")
    public String name_subject;

    @ColumnInfo(name = "first_name_professor")
    public String first_name_professor;

    @ColumnInfo(name = "last_name_professor")
    public String last_name_professor;

    public Subjects(){}

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getName_subject() {
        return name_subject;
    }

    public void setName_subject(String name_subject) {
        this.name_subject = name_subject;
    }

    public String getFirst_name_professor() {
        return first_name_professor;
    }

    public void setFirst_name_professor(String first_name_professor) {
        this.first_name_professor = first_name_professor;
    }

    public String getLast_name_professor() {
        return last_name_professor;
    }

    public void setLast_name_professor(String last_name_professor) {
        this.last_name_professor = last_name_professor;
    }
}
