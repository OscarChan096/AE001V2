package com.softchan.agendaescolar.dbroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "homework")
public class Homework {

    @NonNull
    @PrimaryKey
    public int tarea_id;

    @ColumnInfo(name = "titulo")
    public String titulo;

    @ColumnInfo(name = "fecha_entrega")
    private Date fecha_entrega;

    @ColumnInfo(name = "descripcion")
    public String descripcion;

    @ColumnInfo(name = "subject_homework_id") // "llave foranea" para relacionar los datos de esta entidad con la de asignaturas --- esta columna guardara el id de asignaturas
    public String subject_homework_id;

    public Homework(){}

    public int getTarea_id() {
        return tarea_id;
    }

    public void setTarea_id(int tarea_id) {
        this.tarea_id = tarea_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSubject_homework_id() {
        return subject_homework_id;
    }

    public void setSubject_homework_id(String subject_homework_id) {
        this.subject_homework_id = subject_homework_id;
    }
}
