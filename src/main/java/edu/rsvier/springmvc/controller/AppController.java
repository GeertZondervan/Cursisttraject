package edu.rsvier.springmvc.controller;

import edu.rsvier.springmvc.model.Persoon;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.rsvier.springmvc.service.PersoonService;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    PersoonService service;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String listPersonen(ModelMap model) {

        List<Persoon> personen = service.findAllPersonen();
        model.addAttribute("personen", personen);
        return "start";
    }     
}
