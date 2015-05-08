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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Wiemer
 */
@Controller
@RequestMapping(value = {"/registratie"})
public class RegistratiepaginaController {

    @Autowired
    PersoonService service;

    @RequestMapping( method = RequestMethod.POST)

    public String savePersoon(@Valid Persoon persoon, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "registratie";
        }
        
        service.create(persoon);
        model.addAttribute("persoon", persoon);
        return "/list";
    }

}
