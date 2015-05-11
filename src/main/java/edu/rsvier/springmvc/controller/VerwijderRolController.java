/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rsvier.springmvc.controller;

import edu.rsvier.springmvc.model.Rol;
import edu.rsvier.springmvc.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VerwijderRolController {

    @Autowired
    RolService rolService;
    
    @RequestMapping(value = {"/deleterol-{rolId}"}, method = RequestMethod.GET)
    public String deleteRolGet(@PathVariable int rolId, Rol rol, ModelMap model) {
        rol = rolService.read(rolId);
        model.addAttribute("rol", rol);
        return "verwijderrol";
    }
    
    @RequestMapping(value = {"/deleterol-{rolId}"}, method = RequestMethod.POST)
    public String deleteRolPost(@PathVariable int rolId, Rol rol, ModelMap model) {
        rolService.delete(rolService.read(rolId));
         model.addAttribute("succes", "Deze rol is succesvol verwijderd");
        return "bevestigingspagina";
    }
    

}

