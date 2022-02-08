package com.eep.CUIB.Repository;

import com.eep.CUIB.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("UsuariosJPARepository")
public interface UsuariosJPARepository extends JpaRepository<Usuarios, Serializable> {
}
