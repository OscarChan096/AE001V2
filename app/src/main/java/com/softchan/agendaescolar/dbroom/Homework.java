package com.softchan.agendaescolar.dbroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "homework")
public class Homework {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="asignatura")
    public String asignatura;

    @ColumnInfo(name = "titulo")
    public String titulo;

    @ColumnInfo(name = "fecha_entrega")
    private String fecha_entrega;
    //private Date fecha_entrega;

    @ColumnInfo(name = "descripcion")
    public String descripcion;

    @ColumnInfo(name = "categoria")
    public int categoria; // homework = 0

    public Homework(){}

    @Ignore
    public Homework(String asignatura, String titulo, String fecha_entrega, String descripcion){
        this.asignatura = asignatura;
        this.titulo = titulo;
        this.fecha_entrega = fecha_entrega;
        this.descripcion = descripcion;
        this.categoria = 0;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
