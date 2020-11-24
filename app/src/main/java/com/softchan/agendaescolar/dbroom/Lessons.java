package com.softchan.agendaescolar.dbroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Lessons {

    @PrimaryKey public String subject_dia_id; // llave primaria creada a partir de subject_lesson_id + dia

    @ColumnInfo(name = "dia")
    public String dia;

    @ColumnInfo(name = "hora")
    public Date hora;

    @ColumnInfo(name = "aula")
    public String aula;

    public String subject_lesson_id; // llave foranea --- en esta columna se guarda el id de asignaturas

}
