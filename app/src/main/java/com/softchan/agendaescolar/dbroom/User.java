package com.softchan.agendaescolar.dbroom;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "num_control")
    public String num_control;

    @ColumnInfo(name = "nombre_alumno")
    public String nombre_alumno;

    @ColumnInfo(name = "escuela")
    public String escuela;

    @ColumnInfo(name = "especialidad")
    public String especialidad;

    @ColumnInfo(name = "num_telefono")
    public int num_telefono;


    public User(){}

    @Ignore
    public User(String nombre_alumno, String escuela, String especialidad, int num_telefono, String num_control){
        this.nombre_alumno = nombre_alumno;
        this.escuela = escuela;
        this.especialidad = especialidad;
        this.num_telefono = num_telefono;
        this.num_control = num_control;
    }


    public String getNombreAlumno() {
        return nombre_alumno;
    }

    public void setNombreAlumno(String nombre_usuario) {
        this.nombre_alumno = nombre_usuario;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getNum_telefono() {
        return num_telefono;
    }

    public void setNum_telefono(int num_telefono) {
        this.num_telefono = num_telefono;
    }

    public String getNum_control() {
        return num_control;
    }

    public void setNum_control(String num_control) {
        this.num_control = num_control;
    }
}
