package com.eep.CUIB.ServicesImpl;

import com.eep.CUIB.Entity.Alumnos;
import com.eep.CUIB.Model.Asignaturas;
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

    @Autowired
    @Qualifier("AsignaturasServiceImpl")
    private AsignaturasServiceImpl asignaturasService;

    @Override
    public List<Alumnos> listAllAlumnos() {
        return alumnosJPARepository.findAll();
    }

    @Override
    public Alumnos addAlumnos(Alumnos alumnos, ArrayList<Integer> asignaturas) {
        String asignaturas_id = "";
        for (int i = 0; i < asignaturas.size(); i++) {
            asignaturas_id = asignaturas_id + "#" + asignaturas.get(i);
        }
        System.out.println(asignaturas_id);
        alumnos.setId_asignatura(asignaturas_id);
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

    @Override
    public List<Asignaturas> Listado_Asignaturas_usuario(Optional<Alumnos> alumnos) {
        List<Asignaturas> asignaturas_filtradas = new ArrayList<>();
        String[] asig_usuario = null;
        for (int i = 0; i < alumnos.get().getId_asignatura().length(); i++) {
            asig_usuario = alumnos.get().getId_asignatura().split("#");
        }
        for (int j = 0; j < asig_usuario.length; j++) {
            asignaturas_filtradas.add(asignaturasService.buscarAsignaturas(Integer.parseInt(asig_usuario[j])));
        }
        return asignaturas_filtradas;
    }
}
