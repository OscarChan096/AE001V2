package com.softchan.agendaescolar.dbroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "lessons")
public class Lessons {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int id; // llave primaria creada a partir de subject_id + dia

    @ColumnInfo(name = "dia")
    public int dia;

    @ColumnInfo(name = "name_subject")
    public String name_subject;

    @ColumnInfo(name = "name_professor")
    public String name_professor;

    @ColumnInfo(name = "hora_empiezo")
    public String hora_empiezo;

    @ColumnInfo(name = "hora_fin")
    public String hora_fin;

    @ColumnInfo(name = "aula")
    public String aula;

    @ColumnInfo(name = "categoria")
    public int categoria; // lesson = 1

    //public String subject_id; // llave foranea --- en esta columna se guarda el id de asignaturas

    public Lessons(){}

    @Ignore
    public Lessons(int dia, String asignatura, String hora1, String hora2, String aula, String profesor){
        //this.lesson_id = id;
        this.dia = dia;
        this.name_subject = asignatura;
        this.hora_empiezo = hora1;
        this.hora_fin = hora2;
        this.aula = aula;
        this.name_professor = profesor;
        this.categoria = 1;
    }

    public int getId() {
        return id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getHoraEmpiezo() {
        return hora_empiezo;
    }

    public void setHoraEmpiezo(String hora_empiezo) {
        this.hora_empiezo = hora_empiezo;
    }

    public String getHoraFin() {
        return hora_fin;
    }

    public void setHoraFin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
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

    public void setFirst_name_professor(String name_professor) {
        this.name_professor = name_professor;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
