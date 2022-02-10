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

@Service("AlumnosServiceImpl")
public class AlumnosServiceImpl implements AlumnosService {

    @Autowired
    @Qualifier("AlumnosJPARepository")
    private AlumnosJPARepository alumnosJPARepository;

    @Override
    public List<Alumnos> listAllAlumnos() {
        return alumnosJPARepository.findAll();
    }

    @Override
    public Alumnos addAlumnos(Alumnos alumnos) {
        return alumnosJPARepository.save(alumnos);
    }

    @Override
    public Alumnos updateAlumnos(Alumnos alumnos) {
        return alumnosJPARepository.save(alumnos);
    }

    @Override
    public Optional<Alumnos> findbyid(Long id) {
        Optional<Alumnos> alumno_id = alumnosJPARepository.findById(id);
        return alumno_id;
    }

    @Override
    public void delbyid(Long ids) {
        alumnosJPARepository.deleteById(ids);
    }

    @Override
    public Alumnos Model_Entity_Alumnos(ModelAlumnos modelAlumnos) {
        Alumnos alumno = new Alumnos();

        alumno.setId(modelAlumnos.getId());
        alumno.setNombre(modelAlumnos.getNombre());
        alumno.setApellidos(modelAlumnos.getApellidos());
        alumno.setDireccion(modelAlumnos.getDireccion());
        alumno.setLocalidad(modelAlumnos.getLocalidad());
        alumno.setProvincia(modelAlumnos.getProvincia());
        alumno.setPais(modelAlumnos.getPais());
        alumno.setTelefono(modelAlumnos.getTelefono());
        alumno.setId_asignatura(modelAlumnos.getId_asignatura());

        return alumno;
    }
}
