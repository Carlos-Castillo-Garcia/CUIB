package com.eep.CUIB.Controller;

import com.eep.CUIB.Component.LogComponent;
import com.eep.CUIB.Entity.Alumnos;
import com.eep.CUIB.Entity.Usuarios;
import com.eep.CUIB.Model.Asignaturas;
import com.eep.CUIB.Model.ModelAlumnos;
import com.eep.CUIB.ServicesImpl.AlumnosServiceImpl;
import com.eep.CUIB.ServicesImpl.AsignaturasServiceImpl;
import com.eep.CUIB.ServicesImpl.UsuariosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
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

    private static int id = 0;

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
    @GetMapping("listasignaturasget")
    public String ListAsignaturasGet(Model model, @RequestParam(value = "url", required = false) String url) {
        model.addAttribute("asignaturas", asignaturasServiceImpl.LeerAsignaturas());
        model.addAttribute("url", url);
        return LIST_ASIGNATURAS;
    }

    @GetMapping("addasignaturasget")
    public String AddAsignaturasGet(Model model) {
        model.addAttribute("asignatura", new Asignaturas());
        return ADD_ASIGNATURAS;
    }

    @GetMapping("updateasignaturasget")
    public String UpdateAsginaturasGet(Model model, @RequestParam (value = "ids") int id) {
        model.addAttribute("asignatura", asignaturasServiceImpl.buscarAsignaturas(id));
        return UPDATE_ASIGNATURAS;
    }
    // FIN GET'S DE ASIGNATURAS


    // INICIO POST'S DE ASIGNATURAS
    @PostMapping("addasignaturaspost")
    public String AddAsignaturasPost(@ModelAttribute(name = "asignatura") Asignaturas asignatura) {
        ArrayList<Asignaturas> listado_asignaturas = new ArrayList<>();
        listado_asignaturas.add(asignatura);
        asignaturasServiceImpl.GuardarAsignaturas(listado_asignaturas);
        return "redirect:listasignaturasget";
    }

    @PostMapping("updateasignaturaspost")
    public String UpdateAsignaturasPost(@Valid @ModelAttribute(name = "asignatura") Asignaturas asignaturas, BindingResult result) {
        if (result.hasErrors()){
            return UPDATE_ASIGNATURAS;
        }else {
            asignaturasServiceImpl.ModificacionAsignaturas(asignaturas);
            return "redirect:listasignaturasget";
        }
    }

    @PostMapping("delasignaturaspost")
    public String DeleteAsignaturasPost(@RequestParam (value = "ids") int id) {
        asignaturasServiceImpl.BajaAsignaturasId(id);
        return "redirect:listasignaturasget";
    }
    // FIN POST'S DE ASIGNATURAS

//  FIN GET'S Y POST'S DE ASIGNATURAS


//  INICIO GET's y POST's DE ALUMNOS

    // INICIO GET'S DE ALUMNOS
    @GetMapping("listalumnosget")
    public String ListAlumnosGet(Model model) {
        model.addAttribute("alumnos", alumnosServiceImpl.listAllAlumnos());
        return LIST_ALUMNOS;
    }

    @GetMapping("addalumnosget")
    public String AddAlumnosGet(Model model) {
        model.addAttribute("alumno", new Alumnos());
        model.addAttribute("asignaturas", asignaturasServiceImpl.LeerAsignaturas());
        return ADD_ALUMNOS;
    }

    @GetMapping("updatealumnosget")
    public String UpdateAlumnosGet(Model model, @RequestParam (value = "ids") Long id) {
        model.addAttribute("alumno", alumnosServiceImpl.findbyid(id));
        model.addAttribute("asignaturas", asignaturasServiceImpl.LeerAsignaturas());

        return UPDATE_ALUMNOS;
    }
    // FIN GET'S DE ALUMNOS


    // INICIO POST'S DE ALUMNOS
    @PostMapping("addalumnospost")
    public String AddAlumnosPost(@Valid @ModelAttribute(name = "alumno") ModelAlumnos alumno, BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("asignaturas", asignaturasServiceImpl.LeerAsignaturas());
            return ADD_ALUMNOS;
        }else{
            alumnosServiceImpl.addAlumnos(alumnosServiceImpl.Model_Entity_Alumnos(alumno));
            return "redirect:listalumnosget?url=a";
        }
    }

    @PostMapping("updatealumnospost")
    public String UpdateAlumnosPost(@Valid @ModelAttribute(name = "alumno") ModelAlumnos alumno, BindingResult result) {
        if (result.hasErrors()){
            return UPDATE_ALUMNOS;
        }else{
            alumnosServiceImpl.updateAlumnos(alumnosServiceImpl.Model_Entity_Alumnos(alumno));
            return "redirect:listalumnosget?url=updatealumnosget";
        }
    }

    @PostMapping("delalumnospost")
    public String DelAlumnosPost(@RequestParam(name = "ids") Long ids) {
        alumnosServiceImpl.delbyid(ids);
        return "redirect:listalumnosget?url=delalumnospost";
    }
    // FIN POST'S DE ALUMNOS

//  FIN GET'S Y POST'S DE ALUMNOS


//  INICIO GET's y POST's DE USUARIOS

    // INICIO GET'S DE USUARIOS
    @GetMapping("listusuariosget")
    public String ListUsuariosGet(Model model, @RequestParam(value = "url", required = false) String url) {
        model.addAttribute("user", usuariosServiceImpl.listAllUsuarios());
        model.addAttribute("url", url);
        return LIST_USERS;
    }

    @GetMapping("addusuariosget")
    public String AddUsuariosGet(Model model) {
        model.addAttribute("usuario", new Usuarios());
        return ADD_USERS;
    }

    @GetMapping("updateusuariosget")
    public String UpdateUsuariosGet(Model model, @RequestParam (value = "ids") Long id) {
        model.addAttribute("usuario", usuariosServiceImpl.findbyid(id));
        return UPDATE_USERS;
    }
    // FIN GET'S DE USUARIOS


    // INICIO POST'S DE USUARIOS
    @PostMapping("addusuariospost")
    public String AddUsuariosPost(@ModelAttribute(name = "usuario") Usuarios usuarios){
        usuariosServiceImpl.addUsuarios(usuarios);
        return "redirect:listusuariosget";
    }

    @PostMapping("updateusuariospost")
    public String UpdateUsuariosPost(@Valid @ModelAttribute (name = "usuario") Usuarios usuarios, BindingResult result){
        if (result.hasErrors()){
            return UPDATE_USERS;
        }else {
            usuariosServiceImpl.updateUsuarios(usuarios);
            return "redirect:listusuariosget";
        }
    }

    @PostMapping("delusuariospost")
    public String DelUsuariosPost(@RequestParam (name = "ids") Long ids){
        usuariosServiceImpl.delbyid(ids);
        return "redirect:listusuariosget";
    }
    // FIN POST'S DE USUARIOS

//  FIN GET'S Y POST'S DE USUARIOS
}
