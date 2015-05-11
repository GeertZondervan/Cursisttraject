/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rsvier.springmvc.controller;

import edu.rsvier.springmvc.model.Persoon;
import edu.rsvier.springmvc.model.Rol;
import edu.rsvier.springmvc.service.PersoonService;
import edu.rsvier.springmvc.service.RolService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WijzigrolController {

    @Autowired
    RolService rolService;
    
    @RequestMapping(value = {"/updaterol-{rolId}"}, method = RequestMethod.GET)
    public String wijzigRolGet(@PathVariable int rolId, Rol rol, ModelMap model) {
        rol = rolService.read(rolId);
        model.addAttribute("rol", rol);
        return "wijzigrol";
    }
    
    @RequestMapping(value = {"/updaterol-{rolId}"}, method = RequestMethod.POST)
    public String wijzigRolPost(@PathVariable int rolId, Rol rol, ModelMap model) {
        Rol rolRead = rolService.read(rolId);
        rolRead = rol;
        rolRead.setId(rolId);
        rolService.update(rol);
        
         model.addAttribute("succes", "De rol " + rol.getNaam() + " is gewijzigd");
        return "bevestigingspagina";
    }
    

}

