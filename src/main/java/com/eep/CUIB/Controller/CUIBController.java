package com.eep.CUIB.Controller;

import com.eep.CUIB.Component.LogComponent;
import com.eep.CUIB.Entity.Alumnos;
import com.eep.CUIB.Entity.Usuarios;
import com.eep.CUIB.Model.Asignaturas;
import com.eep.CUIB.Model.ModelAlumnos;
import com.eep.CUIB.Model.ModelUsers;
import com.eep.CUIB.ServicesImpl.AlumnosServiceImpl;
import com.eep.CUIB.ServicesImpl.AsignaturasServiceImpl;
import com.eep.CUIB.ServicesImpl.UsuariosServiceImpl;
import org.hibernate.dialect.function.AvgWithArgumentCastFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.AbstractRabbitListenerContainerFactoryConfigurer;
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
    private static final String INDEX = "loggin";

    private static final String ADD_ASIGNATURAS = "\\Asignaturas\\addasignatura";
    private static final String LIST_ASIGNATURAS = "\\Asignaturas\\listasignatura";
    private static final String UPDATE_ASIGNATURAS = "\\Asignaturas\\updateasignatura";

    private static final String ADD_ALUMNOS = "\\Alumnos\\addalumno";
    private static final String LIST_ALUMNOS = "\\Alumnos\\listalumno";
    private static final String UPDATE_ALUMNOS = "\\Alumnos\\updatealumno";
    private static final String LIST_ASIGNATURAS_ALUMNO = "\\Alumnos\\listar_asignaturas_alumno";

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


    @GetMapping("/")
    public String Index(Model model) {
        model.addAttribute("user", new Usuarios());
        return INDEX;
    }

    @PostMapping("logged")
    public String logger(@Valid @ModelAttribute(name = "user") ModelUsers user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return INDEX;
        } else if(usuariosServiceImpl.User_Correcto(usuariosServiceImpl.Model_Entity_Usuarios(user))){
            model.addAttribute("css_permisos", usuariosServiceImpl.Validar_User(usuariosServiceImpl.Model_Entity_Usuarios(user)));
            logComponent.info("Usuario Loggeado correctamente");
            return CRUD;
        }
        logComponent.errores("El usuario no es correcto");
        return INDEX;
    }

//  INICIO GET's y POST's DE ASIGNATURAS

    // INICIO GET'S DE ASIGNATURAS
    @GetMapping("listasignaturasget")
    public String ListAsignaturasGet(Model model, @RequestParam(value = "url", required = false) String url) {
        model.addAttribute("asignaturas", asignaturasServiceImpl.LeerAsignaturas());
        model.addAttribute("url", url);
        logComponent.info("Asignaturas listadas correctamente");
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
    public String AddAsignaturasPost(@Valid @ModelAttribute(name = "asignatura") Asignaturas asignatura, BindingResult result) {
        if (result.hasErrors()){
            return ADD_ASIGNATURAS;
        }else {
            ArrayList<Asignaturas> listado_asignaturas = new ArrayList<>();
            listado_asignaturas.add(asignatura);
            asignaturasServiceImpl.GuardarAsignaturas(listado_asignaturas);
            logComponent.info("Asignatura Guardada correctamente");
            return "redirect:listasignaturasget";
        }
    }

    @PostMapping("updateasignaturaspost")
    public String UpdateAsignaturasPost(@Valid @ModelAttribute(name = "asignatura") Asignaturas asignaturas, BindingResult result) {
        if (result.hasErrors()){
            return UPDATE_ASIGNATURAS;
        }else {
            asignaturasServiceImpl.ModificacionAsignaturas(asignaturas);
            logComponent.info("Asignatura Modificada Correctamente");
            return "redirect:listasignaturasget";
        }
    }

    @PostMapping("delasignaturaspost")
    public String DeleteAsignaturasPost(@RequestParam (value = "ids") int id) {
        asignaturasServiceImpl.BajaAsignaturasId(id);
        logComponent.info("Asignatura dada de baja correctamente");
        return "redirect:listasignaturasget";
    }
    // FIN POST'S DE ASIGNATURAS

//  FIN GET'S Y POST'S DE ASIGNATURAS


//  INICIO GET's y POST's DE ALUMNOS

    // INICIO GET'S DE ALUMNOS
    @GetMapping("listalumnosget")
    public String ListAlumnosGet(Model model) {
        model.addAttribute("alumnos", alumnosServiceImpl.listAllAlumnos());
//        model.addAttribute("asignaturas", alumnosServiceImpl.Listado_Asignaturas_usuario(alumnosServiceImpl.listAllAlumnos()));
        logComponent.info("Alumnos listado correctamente");
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

    @GetMapping("asig_x_alumnos")
    public String asignaturas_x_alumnos(Model model, @RequestParam (value = "id_alumno") Long id_alumno){
        model.addAttribute("asignaturas", alumnosServiceImpl.Listado_Asignaturas_usuario(alumnosServiceImpl.findbyid(id_alumno)));
        return LIST_ASIGNATURAS_ALUMNO;
    }
    // FIN GET'S DE ALUMNOS


    // INICIO POST'S DE ALUMNOS
    @PostMapping("addalumnospost")
    public String AddAlumnosPost(@Valid @ModelAttribute(name = "alumno") ModelAlumnos alumno,
                                 @RequestParam(value = "asignaturas") ArrayList<Integer> asignaturas, BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("asignaturas", asignaturasServiceImpl.LeerAsignaturas());
            return ADD_ALUMNOS;
        }else{
            System.out.println(asignaturas);
            alumnosServiceImpl.addAlumnos(alumnosServiceImpl.Model_Entity_Alumnos(alumno), asignaturas);
            logComponent.info("Alumno añadido correctamente");
            return "redirect:listalumnosget?url=a";
        }
    }

    @PostMapping("updatealumnospost")
    public String UpdateAlumnosPost(@Valid @ModelAttribute(name = "alumno") ModelAlumnos alumno, BindingResult result) {
        if (result.hasErrors()){
            return UPDATE_ALUMNOS;
        }else{
            alumnosServiceImpl.updateAlumnos(alumnosServiceImpl.Model_Entity_Alumnos(alumno));
            logComponent.info("Alumno modificado correctamente");
            return "redirect:listalumnosget?url=updatealumnosget";
        }
    }

    @PostMapping("delalumnospost")
    public String DelAlumnosPost(@RequestParam(name = "ids") Long ids) {
        alumnosServiceImpl.delbyid(ids);
        logComponent.info("Alumno borrado correctamente");
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
        logComponent.info("Usuarios listado correctamente");
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
    public String AddUsuariosPost(@Valid @ModelAttribute(name = "usuario") ModelUsers usuarios, BindingResult result){
        if (result.hasErrors()){
            return ADD_USERS;
        }else {
            usuariosServiceImpl.addUsuarios(usuariosServiceImpl.Model_Entity_Usuarios(usuarios));
            logComponent.info("Usuario añadido correctamente");
            return "redirect:listusuariosget";
        }
    }

    @PostMapping("updateusuariospost")
    public String UpdateUsuariosPost(@Valid @ModelAttribute (name = "usuario") ModelUsers usuarios, BindingResult result){
        if (result.hasErrors()){
            return UPDATE_USERS;
        }else {
            usuariosServiceImpl.updateUsuarios(usuariosServiceImpl.Model_Entity_Usuarios(usuarios));
            logComponent.info("Usuario modificado correctamente");
            return "redirect:listusuariosget";
        }
    }

    @PostMapping("delusuariospost")
    public String DelUsuariosPost(@RequestParam (name = "ids") Long ids){
        usuariosServiceImpl.delbyid(ids);
        logComponent.info("Usuario borrado correctamente");
        return "redirect:listusuariosget";
    }
    // FIN POST'S DE USUARIOS

//  FIN GET'S Y POST'S DE USUARIOS
}
