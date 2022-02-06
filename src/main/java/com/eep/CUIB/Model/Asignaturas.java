package com.eep.CUIB.Model;

public class Asignaturas {

    int id;
    String nombre;
    int curso;
    int horas;
    int cuatrimestre;

    public Asignaturas() {
    }

    public Asignaturas(int id, String nombre, int curso, int horas, int cuatrimestre) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        this.horas = horas;
        this.cuatrimestre = cuatrimestre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCurso() {
        return curso;
    }

    public int getHoras() {
        return horas;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("#").append(id);
        sb.append("#").append(nombre);
        sb.append("#").append(curso);
        sb.append("#").append(horas);
        sb.append("#").append(cuatrimestre);
        sb.append("#");
        return sb.toString();
    }
}
