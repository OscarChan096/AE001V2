package com.softchan.agendaescolar.dbroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "lessons")
public class Lessons {

    @NonNull
    @PrimaryKey
    public String subject_dia_id; // llave primaria creada a partir de subject_lesson_id + dia

    @ColumnInfo(name = "dia")
    public String dia;

    @ColumnInfo(name = "hora")
    public Date hora;

    @ColumnInfo(name = "aula")
    public String aula;

    public String subject_lesson_id; // llave foranea --- en esta columna se guarda el id de asignaturas

    public Lessons(){}

    @NonNull
    public String getSubject_dia_id() {
        return subject_dia_id;
    }

    public void setSubject_dia_id(@NonNull String subject_dia_id) {
        this.subject_dia_id = subject_dia_id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getSubject_lesson_id() {
        return subject_lesson_id;
    }

    public void setSubject_lesson_id(String subject_lesson_id) {
        this.subject_lesson_id = subject_lesson_id;
    }
}
