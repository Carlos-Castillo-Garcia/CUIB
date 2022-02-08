package com.eep.CUIB.Repository;

import com.eep.CUIB.Entity.Alumnos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("AlumnosJPARepository")
public interface AlumnosJPARepository extends JpaRepository<Alumnos, Serializable> {
}
