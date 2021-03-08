package com.softchan.agendaescolar.dbroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "subjects") // asignaturas
public class Subjects {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int subject_id; // llave primaria se crea con las 3 primeras letras del nombre de la asignatura y numero aleatorio

    @ColumnInfo(name = "name_subject")
    public String name_subject;

    @ColumnInfo(name = "name_professor")
    public String name_professor;

    @ColumnInfo(name = "aula")
    public String aula;

    public Subjects(){}

    @Ignore
    public Subjects(String subject, String profesor, String aula){
        this.name_subject = subject;
        this.name_professor = profesor;
        this.aula = aula;
    }

    public int getSubjectId() {
        return subject_id;
    }

    public void setSubjectId(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getNameSubject() {
        return name_subject;
    }

    public void setNameSubject(String name_subject) {
        this.name_subject = name_subject;
    }

    public String getNameProfessor() {
        return name_professor;
    }

    public void setNameProfessor(String first_name_professor) {
        this.name_professor = first_name_professor;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
}
