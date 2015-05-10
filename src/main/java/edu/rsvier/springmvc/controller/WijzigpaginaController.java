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
public class WijzigpaginaController {

    @Autowired
    PersoonService service;
    
    @RequestMapping(value = {"/update-{persoonid}"}, method = RequestMethod.GET)
    public String getPersoon(@PathVariable int persoonid, Persoon persoon, ModelMap model) {
        persoon = service.read(persoonid);
        model.addAttribute("persoon", persoon);
        return "wijzig";
    }
    
    @RequestMapping(value = {"/update-{persoonid}"}, method = RequestMethod.POST)
    public String wijzigPersoonPost(@PathVariable int persoonid, Persoon persoon, ModelMap model) {
        Persoon persoonRead = service.read(persoonid);
        persoonRead = persoon;
        persoonRead.setId(persoonid);
        service.update(persoon);
        
         model.addAttribute("succes", persoon.getVoornaam() + " "
                + persoon.getAchternaam() + " is gewijzigd");
        return "bevestigingspagina";
    }
    

}

