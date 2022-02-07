package com.eep.CUIB.Controller;

import com.eep.CUIB.Component.AsignaturasComponent;
import com.eep.CUIB.Entity.Usuarios;
import com.eep.CUIB.Model.Asignaturas;
import com.eep.CUIB.ServicesImpl.AsignaturasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class CUIBController {

    private static final String ADD_ASIGNATURAS = "addasignaturas";

    @Autowired
    @Qualifier("AsignaturasServiceImpl")
    private AsignaturasServiceImpl asignaturasService;

    @Autowired
    @Qualifier("AsignaturasComponent")
    private AsignaturasComponent asignaturasComponent;

    public String login(Model model){
        model.addAttribute("login", new Usuarios());
        return "index";
    }

    @GetMapping("/addasignaturasget")
    public String getAddAsignaturas(Model model){
        model.addAttribute("asiganturas", new Asignaturas());
        return ADD_ASIGNATURAS;
    }

    @PostMapping("/addasignaturaspost")
    public String postAddAsignaturas(@ModelAttribute("asignaturas") Asignaturas asignaturas){
        ArrayList<Asignaturas> list_asignaturas = new ArrayList<>();
        list_asignaturas.add(asignaturas);
        asignaturasComponent.info(asignaturasService.GuardarAsignaturas(list_asignaturas));
        return "index";
    }
}
