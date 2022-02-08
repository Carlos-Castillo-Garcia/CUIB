package com.eep.CUIB.Services;

import com.eep.CUIB.Entity.Alumnos;
import com.eep.CUIB.Model.ModelAlumnos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface AlumnosService {
    List<Alumnos> listAllAlumnos();

    Alumnos addAlumnos(Alumnos alumnos);

    Alumnos updateAlumnos(Alumnos alumnos);

    Optional<Alumnos> findbyid(int id);

    void delbyid(ArrayList<Long> ids);

    Alumnos Model_Entity_Alumnos(ModelAlumnos alumnos);
}
