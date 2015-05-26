package edu.rsvier.springmvc.controller;

import edu.rsvier.springmvc.model.Rol;
import edu.rsvier.springmvc.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NieuwerolController {

    @Autowired
    RolService rolService;

    @RequestMapping(value = {"/nieuwerol"}, method = RequestMethod.GET)
    public String nieuweRolGet(Rol rol, ModelMap model) {

        model.addAttribute("rol", rol);
        return "nieuwerol";
    }

    @RequestMapping(value = {"/nieuwerol"}, method = RequestMethod.POST)
    public String nieuweRolPost(Rol rol, ModelMap model) {
        rolService.create(rol);
        model.addAttribute("rol", rol);
        model.addAttribute("succes", "De rol " + rol.getNaam() + " is toegevoegd");
        return "bevestigingspagina";
    }

//    @RequestMapping(value="/nieuwpersoon", method = RequestMethod.POST)
//
//    public String savePersoon(@Valid Persoon persoon, BindingResult result,
//            ModelMap model) {
//
//        if (result.hasErrors()) {
//            return "registratie";
//        }
//        
//        service.create(persoon);
//        model.addAttribute("succes", persoon.getVoornaam() + " "
//                + persoon.getAchternaam() + " staat geregistreerd");
//        return "bevestigingspagina";
//    }
}
