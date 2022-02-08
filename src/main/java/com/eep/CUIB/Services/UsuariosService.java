package com.eep.CUIB.Services;

import com.eep.CUIB.Entity.Usuarios;
import com.eep.CUIB.Model.ModelUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UsuariosService {
    List<Usuarios> listAllUsuarios();

    Usuarios addUsuarios(Usuarios usuarios);

    Usuarios updateUsuarios(Usuarios usuarios);

    Optional<Usuarios> findbyid(int id);

    void delbyid(ArrayList<Long> ids);

    Usuarios Model_Entity_Usuarios(ModelUsers usuarios);
}
