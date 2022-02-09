package com.eep.CUIB.Controller;

import com.eep.CUIB.Component.LogComponent;
import com.eep.CUIB.Entity.Alumnos;
import com.eep.CUIB.Model.ModelAlumnos;
import com.eep.CUIB.ServicesImpl.AlumnosServiceImpl;
import com.eep.CUIB.ServicesImpl.AsignaturasServiceImpl;
import com.eep.CUIB.ServicesImpl.UsuariosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


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

////  INICIO GET's y POST's DE ASIGNATURAS
//
//    // INICIO GET'S DE ASIGNATURAS
//    @GetMapping("listasignaturasget")
//    public String ListAsignaturasGet(Model model) {
//        model.addAttribute("asignaturas", asignaturasServiceImpl.LeerAsignaturas());
//        return LIST_ASIGNATURAS;
//    }
//
//    @GetMapping("addasignaturasget")
//    public String AddAsignaturasGet(Model model) {
//        model.addAttribute("asignatura", new Asignaturas());
//        return ADD_ASIGNATURAS;
//    }
//
//    @GetMapping("updateasignaturasget")
//    public String UpdateAsginaturasGet(Model model, Asignaturas asignatura) {
//        model.addAttribute("asignatura", asignatura);
//        return UPDATE_ASIGNATURAS;
//    }
//    // FIN GET'S DE ASIGNATURAS
//
//
//    // INICIO POST'S DE ASIGNATURAS
//    @PostMapping("addasignaturaspost")
//    public String AddAsignaturasPost(@ModelAttribute(name = "asignatura") Asignaturas asignatura) {
//        ArrayList<Asignaturas> listado_asignaturas = new ArrayList<>();
//        listado_asignaturas.add(asignatura);
//        asignaturasServiceImpl.GuardarAsignaturas(listado_asignaturas);
//        return "redirect:listasignaturasget";
//    }
//
//    @PostMapping("updateasignaturaspost")
//    public String UpdateAsignaturasPost() {
//        //Crear metodo de actualizacion de asignaturas
//        return "redirect:listasignaturasget";
//    }
//
//    @PostMapping("deleteasignaturaspost")
//    public String DeleteAsignaturasPost() {
//        //Crear metodo de borrado de asignaturas
//        return "redirect:listasignaturasget";
//    }
//    // FIN POST'S DE ASIGNATURAS
//
////  FIN GET'S Y POST'S DE ASIGNATURAS


//  INICIO GET's y POST's DE ALUMNOS

    // INICIO GET'S DE ALUMNOS
    @GetMapping("listalumnosget")
    public String ListAlumnosGet(Model model, @RequestParam(value = "url") String url) {
        model.addAttribute("alumnos", alumnosServiceImpl.listAllAlumnos());
        model.addAttribute("url", url);
        return LIST_ALUMNOS;
    }

    @GetMapping("addalumnosget")
    public String AddAlumnosGet(Model model) {
        model.addAttribute("alumno", new Alumnos());
        return ADD_ALUMNOS;
    }

    @GetMapping("updatealumnosget")
    public String UpdateAlumnosGet(Model model, Alumnos alumnos) {
        model.addAttribute("alumno", alumnos);
        return UPDATE_ALUMNOS;
    }
    // FIN GET'S DE ALUMNOS


    // INICIO POST'S DE ALUMNOS
    @PostMapping("addalumnospost")
    public String AddAlumnosPost(@Validated @ModelAttribute(name = "alumno") ModelAlumnos alumno, BindingResult result) {
        if (result.hasErrors()){
            return ADD_ALUMNOS;
        }else{
            alumnosServiceImpl.addAlumnos(alumnosServiceImpl.Model_Entity_Alumnos(alumno));
            return "redirect:listalumnosget?url=a";
        }
    }

    @PostMapping("updatealumnospost")
    public String UpdateAlumnosPost(@Validated @ModelAttribute(name = "alumno") ModelAlumnos alumno, BindingResult result) {
        if (result.hasErrors()){
            return UPDATE_ALUMNOS;
        }else{
            alumnosServiceImpl.updateAlumnos(alumnosServiceImpl.Model_Entity_Alumnos(alumno));
            return "redirect:listalumnosget?url=a";
        }
    }

    @PostMapping("delalumnospost")
    public String DelAlumnosPost(@RequestParam(name = "ids") ArrayList<Long> ids) {
        alumnosServiceImpl.delbyid(ids);
        return "redirect:listalumnosget";
    }
    // FIN POST'S DE ALUMNOS

//  FIN GET'S Y POST'S DE ALUMNOS


////  INICIO GET's y POST's DE USUARIOS
//
//    // INICIO GET'S DE USUARIOS
//    @GetMapping("listusuariosget")
//    public String ListUsuariosGet(Model model) {
//        model.addAttribute("usuarios", usuariosServiceImpl.listAllUsuarios());
//        return LIST_USERS;
//    }
//
//    @GetMapping("addusuariosget")
//    public String AddUsuariosGet(Model model) {
//        model.addAttribute("usuario", new Usuarios());
//        return ADD_USERS;
//    }
//
//    @GetMapping("updateusuariosget")
//    public String UpdateUsuariosGet(Model model, Usuarios usuario) {
//        model.addAttribute("usuario", usuario);
//        return UPDATE_USERS;
//    }
//    // FIN GET'S DE USUARIOS
//
//
//    // INICIO POST'S DE USUARIOS
//    @PostMapping("addusuariospost")
//    public String AddUsuariosPost(@ModelAttribute(name = "usuario") Usuarios usuarios){
//        usuariosServiceImpl.addUsuarios(usuarios);
//        return "redirect:listusuariosget";
//    }
//
//    @PostMapping("updateusuariospost")
//    public String UpdateUsuariosPost(@ModelAttribute (name = "usuario") Usuarios usuarios){
//        usuariosServiceImpl.updateUsuarios(usuarios);
//        return "redirect:listusuariosget";
//    }
//
//    @PostMapping("delusuariosspost")
//    public String DelUsuariosPost(@RequestParam (name = "ids") ArrayList<Long> ids){
//        usuariosServiceImpl.delbyid(ids);
//        return "redirect:listusuariosget";
//    }
//    // FIN POST'S DE USUARIOS
//
////  FIN GET'S Y POST'S DE USUARIOS
}
