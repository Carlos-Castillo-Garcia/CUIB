package com.eep.CUIB.Services;

import com.eep.CUIB.Entity.Alumnos;
import com.eep.CUIB.Model.ModelAlumnos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface AlumnosService {
    List<Alumnos> listAllCoches();

    Alumnos addCoches(Alumnos coches);

    int removeCoches(int id);

    Alumnos updateCoches(Alumnos coches);

    Optional<Alumnos> findbyid(int id);

    void delbyid(ArrayList<Integer> ids);

    Alumnos Model_Entity_Alumnos(ModelAlumnos coche);
}
