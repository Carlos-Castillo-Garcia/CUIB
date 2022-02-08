package com.eep.CUIB.ServicesImpl;

import com.eep.CUIB.Entity.Alumnos;
import com.eep.CUIB.Model.ModelAlumnos;
import com.eep.CUIB.Repository.AlumnosJPARepository;
import com.eep.CUIB.Services.AlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("AlumosServiceImpl")
public class AlumosServiceImpl implements AlumnosService {

    @Autowired
    @Qualifier("AlumnosJPARepository")
    private AlumnosJPARepository alumnosJPARepository;

    @Override
    public List<Alumnos> listAllCoches() {
        return null;
    }

    @Override
    public Alumnos addCoches(Alumnos coches) {
        return null;
    }

    @Override
    public int removeCoches(int id) {
        return 0;
    }

    @Override
    public Alumnos updateCoches(Alumnos coches) {
        return null;
    }

    @Override
    public Optional<Alumnos> findbyid(int id) {
        return Optional.empty();
    }

    @Override
    public void delbyid(ArrayList<Integer> ids) {

    }

    @Override
    public Alumnos Model_Entity_Alumnos(ModelAlumnos coche) {
        return null;
    }
}
