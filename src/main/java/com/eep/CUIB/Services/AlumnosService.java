package com.eep.CUIB.Services;

import com.eep.CUIB.Entity.Alumnos;
import com.eep.CUIB.Model.Asignaturas;
import com.eep.CUIB.Model.ModelAlumnos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface AlumnosService {
    public abstract List<Alumnos> listAllAlumnos();
    public abstract Alumnos addAlumnos(Alumnos alumnos, ArrayList<Integer> asignaturas);
    public abstract Alumnos updateAlumnos(Alumnos alumnos);
    public abstract Optional<Alumnos> findbyid(Long id);
    public abstract void delbyid(Long ids);
    public abstract Alumnos Model_Entity_Alumnos(ModelAlumnos alumnos);
    public abstract List<Asignaturas> Listado_Asignaturas_usuario (Optional<Alumnos> alumnos);
}
