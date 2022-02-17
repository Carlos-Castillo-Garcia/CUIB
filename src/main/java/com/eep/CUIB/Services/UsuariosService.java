package com.eep.CUIB.Services;

import com.eep.CUIB.Entity.Usuarios;
import com.eep.CUIB.Model.ModelUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UsuariosService {
    public abstract List<Usuarios> listAllUsuarios();

    public abstract Usuarios addUsuarios(Usuarios usuarios);

    public abstract Usuarios updateUsuarios(Usuarios usuarios);

    public abstract Optional<Usuarios> findbyid(Long id);

    public abstract void delbyid(Long ids);

    public abstract Usuarios Model_Entity_Usuarios(ModelUsers usuarios);

    public abstract String Validar_User(Usuarios user);
    public abstract boolean User_Correcto(Usuarios user);
    public abstract void inicio(ArrayList<Usuarios> u);
}
