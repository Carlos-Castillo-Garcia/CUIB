package com.eep.CUIB.Model;

import org.aspectj.bridge.IMessage;

import javax.validation.constraints.NotBlank;

public class ModelAlumnos {

    Long id;
    @NotBlank(message = "Rellene el campo porfavor")
    String nombre;
    @NotBlank(message = "Rellene el campo porfavor")
    String apellidos;
    @NotBlank(message = "Rellene el campo porfavor")
    String direccion;
    @NotBlank(message = "Rellene el campo porfavor")
    String localidad;
    @NotBlank(message = "Rellene el campo porfavor")
    String provincia;
    @NotBlank(message = "Rellene el campo porfavor")
    String pais;
    @NotBlank(message = "Rellene el campo porfavor")
    String telefono;
    String id_asignatura;

    public ModelAlumnos() {
    }

    public ModelAlumnos(Long id, String nombre,
                        String apellidos, String direccion,
                        String localidad, String provincia,
                        String pais, String telefono, String id_asignatura) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
        this.telefono = telefono;
        this.id_asignatura = id_asignatura;
    }

    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getLocalidad() {
        return localidad;
    }
    public String getProvincia() {
        return provincia;
    }
    public String getPais() {
        return pais;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getId_asignatura() {
        return id_asignatura;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setId_asignatura(String id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(nombre);
        sb.append(apellidos);
        sb.append(direccion);
        sb.append(localidad);
        sb.append(provincia);
        sb.append(pais);
        sb.append(telefono);
        sb.append(id_asignatura);
        return sb.toString();
    }
}
