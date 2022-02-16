package com.eep.CUIB.ServicesImpl;

import com.eep.CUIB.Entity.Usuarios;
import com.eep.CUIB.Model.ModelUsers;
import com.eep.CUIB.Repository.UsuariosJPARepository;
import com.eep.CUIB.Services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("UsuariosServiceImpl")
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    @Qualifier("UsuariosJPARepository")
    private UsuariosJPARepository usuariosJPARepository;

    @Override
    public List<Usuarios> listAllUsuarios() {
        return usuariosJPARepository.findAll();
    }

    @Override
    public Usuarios addUsuarios(Usuarios usuarios) {
        return usuariosJPARepository.save(usuarios);
    }

    @Override
    public Usuarios updateUsuarios(Usuarios usuarios) {
        return usuariosJPARepository.save(usuarios);
    }

    @Override
    public Optional<Usuarios> findbyid(Long id) {
        Optional<Usuarios> user = usuariosJPARepository.findById(id);
        return user;
    }

    @Override
    public void delbyid(Long ids_usuarios) {
            usuariosJPARepository.deleteById(ids_usuarios);
    }

    @Override
    public Usuarios Model_Entity_Usuarios(ModelUsers usuarios) {
        Usuarios user = new Usuarios();

        user.setId(usuarios.getId());
        user.setNombre(usuarios.getNombre());
        user.setPassword(usuarios.getPassword());
        user.setPermisos(usuarios.getPermisos());

        return user;
    }

    @Override
    public String Validar_User(Usuarios user_a_validar) {
        ArrayList<Usuarios> listado = (ArrayList<Usuarios>) listAllUsuarios();
        String css = "";
        for (Usuarios usuarios : listado) {
            if (usuarios.getNombre().equals(user_a_validar.getNombre()) &&
                    usuarios.getPassword().equals(user_a_validar.getPassword())) {
                if (usuarios.getPermisos() == 1) {
                    css = "/static/css/permisosadmin.css";
                } else if (usuarios.getPermisos() == 2) {
                    css = "/static/css/permisosuser.css";
                }
            }
        }
        return css;
    }

    @Override
    public boolean User_Correcto(Usuarios user){
        ArrayList<Usuarios> listado = (ArrayList<Usuarios>) listAllUsuarios();
        for (Usuarios usuarios : listado) {
            if (usuarios.getNombre().equals(user.getNombre()) &&
                    usuarios.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

}
