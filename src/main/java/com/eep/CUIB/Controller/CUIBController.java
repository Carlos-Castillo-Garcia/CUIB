package com.eep.CUIB.Controller;

import com.eep.CUIB.Component.LogComponent;
import com.eep.CUIB.Entity.Alumnos;
import com.eep.CUIB.Entity.Usuarios;
import com.eep.CUIB.Model.Asignaturas;
import com.eep.CUIB.ServicesImpl.AlumnosServiceImpl;
import com.eep.CUIB.ServicesImpl.AsignaturasServiceImpl;
import com.eep.CUIB.ServicesImpl.UsuariosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CUIBController {

    private static final String CRUD = "crud";

    private static final String ADD_ASIGNATURAS = "\\Asignaturas\\addasignatura";
    private static final String LIST_ASIGNATURAS = "\\Asignaturas\\listasignatura";
    private static final String UPDATE_ASIGNATURAS = "\\Asignaturas\\updateasignatura";

    private static final String ADD_ALUMNOS = "\\Alumnos\\addalumno";
    private static final String LIST_ALUMNOS = "\\Alumnos\\listalumno";
    private static final String UPDATE_ALUMNOS = "\\Alumnos\\updatealumno";

    private static final String ADD_USERS = "\\Users\\adduser";
    private static final String LIST_USERS = "\\Users\\listuser";
    private static final String UPDATE_USERS = "\\Users\\updateuser";

    // INICIO INSTANCIAS DE IMP
    @Autowired
    @Qualifier("AsignaturasServiceImpl")
    private AsignaturasServiceImpl asignaturasServiceImpl;

    @Autowired
    @Qualifier("AlumnosServiceImpl")
    private AlumnosServiceImpl alumnosServiceImpl;

    @Autowired
    @Qualifier("UsuariosServiceImpl")
    private UsuariosServiceImpl usuariosServiceImpl;
    // FIN INSTANCIAS DE IMPL


    // INICIO INSTANCIAS COMPONENTS
    @Autowired
    @Qualifier("AsignaturasComponent")
    private LogComponent logComponent;
    // FIN INSTANCIAS COMPONENTS


    @GetMapping("getcrud")
    public String CRUDget(Model model) {
        //model.addAttribute("css_permisos", "/css/permisos.css");
        return CRUD;
    }

    //  INICIO GET's y POST's DE ASIGNATURAS
    // INICIO GET'S DE ASIGNATURAS
    @GetMapping("listasignaturas")
    public String ListAsignaturasGet(Model model) {
        model.addAttribute("asignaturas", asignaturasServiceImpl.LeerAsignaturas());
        return LIST_ASIGNATURAS;
    }

    @GetMapping("addasignaturas")
    public String AddAsignaturasGet(Model model) {
        model.addAttribute("asignatura", new Asignaturas());
        return ADD_ASIGNATURAS;
    }

    @GetMapping("updateasignaturas")
    public String UpdateAsginaturasGet(Model model, Asignaturas asignatura) {
        model.addAttribute("asignatura", asignatura);
        return UPDATE_ASIGNATURAS;
    }
    // FIN GET'S DE ASIGNATURAS


    // INICIO POST'S DE ASIGNATURAS

    // FIN POST'S DE ASIGNATURAS

//  FIN GET'S Y POST'S DE ASIGNATURAS


//  INICIO GET's y POST's DE ALUMNOS

    // INICIO GET'S DE ALUMNOS
    @GetMapping("listalumnos")
    public String ListAlumnosGet(Model model) {
        model.addAttribute("alumnos", alumnosServiceImpl.listAllAlumnos());
        return LIST_ALUMNOS;
    }

    @GetMapping("addalumnos")
    public String AddAlumnosGet(Model model) {
        model.addAttribute("alumno", new Alumnos());
        return ADD_ALUMNOS;
    }

    @GetMapping("updatealumnos")
    public String UpdateAlumnosGet(Model model, Alumnos alumnos) {
        model.addAttribute("alumno", alumnos);
        return UPDATE_ALUMNOS;
    }
    // FIN GET'S DE ALUMNOS


    // INICIO POST'S DE ALUMNOS

    // FIN POST'S DE ALUMNOS

//  FIN GET'S Y POST'S DE ALUMNOS


//  INICIO GET's y POST's DE USUARIOS

    // INICIO GET'S DE USUARIOS
    @GetMapping("listusuarios")
    public String ListUsuariosGet(Model model) {
        model.addAttribute("usuarios", usuariosServiceImpl.listAllUsuarios());
        return LIST_USERS;
    }

    @GetMapping("addusuarios")
    public String AddUsuariosGet(Model model) {
        model.addAttribute("usuario", new Usuarios());
        return ADD_USERS;
    }

    @GetMapping("updateusuarios")
    public String UpdateUsuariosGet(Model model, Usuarios usuario) {
        model.addAttribute("usuario", usuario);
        return UPDATE_USERS;
    }
    // FIN GET'S DE USUARIOS


    // INICIO POST'S DE USUARIOS

    // FIN POST'S DE USUARIOS

//  FIN GET'S Y POST'S DE USUARIOS
}
