package edu.rsvier.springmvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.rsvier.springmvc.model.Traject;
import edu.rsvier.springmvc.service.TrajectService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/trajecten")
public class TrajectenoverzichtController {

    @Autowired
    TrajectService trajectService;


    @RequestMapping(value = {"","/trajectenlijst"}, method = RequestMethod.GET)
    public String listPersonen(ModelMap model) {

        List<Traject> trajecten = trajectService.getAll();
        model.addAttribute("trajecten", trajecten);
        return "trajectenoverzicht";
    }
  
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
