package com.eep.CUIB.Model;

import javax.validation.constraints.NotBlank;

public class ModelUsers {

    Long id;

    @NotBlank(message = "Rellene el nombre de usuario")
    String nombre;
    @NotBlank(message = "Escriba una contraseña")
    String password;
    Long permisos;

    public ModelUsers() {
    }

    public ModelUsers(Long id, String nombre, String password, Long permisos) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.permisos = permisos;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public Long getPermisos() {
        return permisos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermisos(Long permisos) {
        this.permisos = permisos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(nombre);
        sb.append(password);
        return sb.toString();
    }
}
