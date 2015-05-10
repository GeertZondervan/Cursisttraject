/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rsvier.springmvc.controller;

import edu.rsvier.springmvc.model.Persoon;
import edu.rsvier.springmvc.service.PersoonService;
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
public class VerwijderpaginaController {

    @Autowired
    PersoonService service;
    
    @RequestMapping(value = {"/delete-{persoonid}"}, method = RequestMethod.GET)
    public String deletePersoonGet(@PathVariable int persoonid, Persoon persoon, ModelMap model) {
        persoon = service.read(persoonid);
        model.addAttribute("persoon", persoon);
        return "verwijder";
    }
    
    @RequestMapping(value = {"/delete-{persoonid}"}, method = RequestMethod.POST)
    public String deletePersoonPost(@PathVariable int persoonid, Persoon persoon, ModelMap model) {
        service.delete(service.read(persoonid));
         model.addAttribute("succes", "Deze persoon is succesvol verwijderd");
        return "bevestigingspagina";
    }
    

}

