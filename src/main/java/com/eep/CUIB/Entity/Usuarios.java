package com.eep.CUIB.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuarios {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nombre", nullable = false)
    String nombre;
    @Column(name = "password", nullable = false)
    String password;
    @Column(name = "permisos", nullable = false)
    Long permisos;

    public Usuarios() {
    }
    public Usuarios(Long id, String nombre, String password, Long permisos) {
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
