package edu.rsvier.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.rsvier.springmvc.model.Rol;
import edu.rsvier.springmvc.service.RolService;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/rollen")
public class RollenlijstController {

    @Autowired
    RolService rolService;

    @RequestMapping(value = {"", "/rollijst"}, method = RequestMethod.GET)
    public String listPersonen(ModelMap model) {

        List<Rol> rollen = rolService.getAll();
        model.addAttribute("rollen", rollen);
        return "Roldomein/rollenpagina";
    }

    @RequestMapping(value = {"/nieuwerol"}, method = RequestMethod.GET)
    public String nieuweRolGet(Rol rol, ModelMap model) {

        model.addAttribute("rol", rol);
        return "Roldomein/nieuwerol";
    }

    @RequestMapping(value = {"/nieuwerol"}, method = RequestMethod.POST)
    public String nieuweRolPost(@Valid Rol rol, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "nieuwerol";
        } else {
            rolService.create(rol);
            model.addAttribute("rol", rol);
            model.addAttribute("succes", "De rol " + rol.getNaam() + " is toegevoegd");
        }
        return "Algemeen/bevestigingspagina";
    }

    @RequestMapping(value = {"/deleterol-{rolId}"}, method = RequestMethod.GET)
    public String deleteRolGet(@PathVariable int rolId, Rol rol, ModelMap model) {
        rol = rolService.read(rolId);
        model.addAttribute("rol", rol);
        return "Roldomein/verwijderrol";
    }

    @RequestMapping(value = {"/deleterol-{rolId}"}, method = RequestMethod.POST)
    public String deleteRolPost(@PathVariable int rolId, Rol rol, ModelMap model) {
        rolService.delete(rolService.read(rolId));
        model.addAttribute("succes", "Deze rol is succesvol verwijderd uit de database");
        return "Algemeen/bevestigingspagina";
    }

    @RequestMapping(value = {"/updaterol-{rolId}"}, method = RequestMethod.GET)
    public String wijzigRolGet(@PathVariable int rolId, Rol rol, ModelMap model) {
        rol = rolService.read(rolId);
        model.addAttribute("rol", rol);
        return "Roldomein/wijzigrol";
    }

    @RequestMapping(value = {"/updaterol-{rolId}"}, method = RequestMethod.POST)
    public String wijzigRolPost(@PathVariable int rolId, Rol rol, ModelMap model) {
        Rol rolRead = rolService.read(rolId);
        rolRead = rol;
        rolRead.setId(rolId);
        rolService.update(rol);

        model.addAttribute("succes", "De rol " + rol.getNaam() + " is gewijzigd");
        return "Algemeen/bevestigingspagina";
    }

}
