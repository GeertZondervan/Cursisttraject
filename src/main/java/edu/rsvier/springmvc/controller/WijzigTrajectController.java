/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rsvier.springmvc.controller;

import edu.rsvier.springmvc.model.Module;
import edu.rsvier.springmvc.model.Traject;
import edu.rsvier.springmvc.service.TrajectService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WijzigTrajectController {

    @Autowired
    TrajectService trajectService;

    @RequestMapping(value = {"/updatetraject-{trajectId}"}, method = RequestMethod.GET)
    public String wijzigTrajectGet(@PathVariable int trajectId, Traject traject, ModelMap model) {
        traject = trajectService.read(trajectId);
        model.addAttribute("traject", traject);
        return "wijzigtraject";
    }

    @RequestMapping(value = {"/updatetraject-{trajectId}"}, method = RequestMethod.POST)
    public String wijzigTrajectPost(@PathVariable int trajectId, Traject traject, ModelMap model) {
        Traject trajectRead = trajectService.read(trajectId);

        trajectRead = traject;
        trajectRead.setId(trajectId);
        trajectService.update(traject);
        return wijzigTrajectGet(trajectId, traject, model);
    }

    @RequestMapping(value = {"/updatetraject-{trajectId}"}, method = RequestMethod.POST, params = "verwijdermodule")
    public String verwijderModule(@PathVariable int trajectId, @RequestParam(value = "verwijdermodule")  int moduleId, Traject traject, ModelMap model) {
        System.out.println("Exterminate" + " " + moduleId);
        traject.setModules(trajectService.read(trajectId).getModules());
        model.addAttribute("traject", traject);
        
        return "wijzigtraject";
    }

}
