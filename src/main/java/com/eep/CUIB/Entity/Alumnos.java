package com.eep.CUIB.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alumnos {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nombre", nullable = false)
    String nombre;
    @Column(name = "apellidos", nullable = false)
    String apellidos;
    @Column(name = "direccion", nullable = false)
    String direccion;
    @Column(name = "localidad", nullable = false)
    String localidad;
    @Column(name = "provincia", nullable = false)
    String provincia;
    @Column(name = "ais", nullable = false)
    String pais;
    @Column(name = "telefono", nullable = false)
    String telefono;
    @Column(name = "id_asignatura", nullable = true)
    int id_asignatura;

    public Alumnos() {
    }
    public Alumnos(Long id, String nombre,
                   String apellidos, String direccion,
                   String localidad, String provincia,
                   String pais, String telefono, int id_asignatura) {
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
    public int getId_asignatura() {
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
    public void setId_asignatura(int id_asignatura) {
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
