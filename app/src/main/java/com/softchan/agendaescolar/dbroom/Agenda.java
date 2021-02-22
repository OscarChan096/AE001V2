package com.softchan.agendaescolar.dbroom;

public class Agenda {

    // ---------------- LESSONS -------------
    //private String lesson_id;
    private int dia;
    private String nameProfesor;
    private String hora;
    private String aula;

    // -------------- HOMEWORK --------------
    private String titulo;
    private String fechaEntrega;
    private String descripcion;

    // --------------- variable polimorfica -------------
    private String asignatura;
    private int categoria;


    // datos para lessons
    public Agenda(int dia, String asignatura, String nameProfesor, String hora, String aula, int categoria){
        //this.lesson_id = lesson_id;
        this.dia = dia;
        this.asignatura = asignatura;
        this.nameProfesor = nameProfesor;
        this.hora = hora;
        this.aula = aula;
        this.categoria = categoria;
    }

    // datos para homeworks
    public Agenda(String asignatura, String titulo, String fechaEntrega, String descripcion, int categoria){
        this.asignatura = asignatura;
        this.titulo = titulo;
        this.fechaEntrega = fechaEntrega;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getNameProfesor() {
        return nameProfesor;
    }

    public void setNameProfesor(String nameProfesor) {
        this.nameProfesor = nameProfesor;
    }

    public String getHora() {
        return hora;
    }

    public void setHoraE(String hora) {
        this.hora = hora;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
