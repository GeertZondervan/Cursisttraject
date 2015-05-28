package edu.rsvier.springmvc.controller;

import edu.rsvier.springmvc.model.Module;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.rsvier.springmvc.model.Traject;
import edu.rsvier.springmvc.service.ModuleService;
import edu.rsvier.springmvc.service.TrajectService;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/trajecten")
public class TrajectenoverzichtController {

    @Autowired
    TrajectService trajectService;

    @Autowired
    ModuleService moduleService;
    
    @RequestMapping(value = {"", "/trajectenlijst"}, method = RequestMethod.GET)
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
        model.addAttribute("succes, Traject", traject.getNaam() + " "
                + "is gewijzigd");
        return "bevestigingspagina";

    }

    @RequestMapping(value = {"delete-{trajectId}"}, method = RequestMethod.GET)
    public String deleteTrajectGet(@PathVariable int trajectId, Traject traject, ModelMap model) {
        traject = trajectService.read(trajectId);
        model.addAttribute("traject", traject);
        return "verwijdertraject";
    }

    @RequestMapping(value = {"delete-{trajectId}"}, method = RequestMethod.POST)
    public String deleteTrajectPost(@PathVariable int trajectId, Traject traject, ModelMap model) {
        trajectService.delete(trajectService.read(trajectId));
        model.addAttribute("succes", "Dit traject is succesvol verwijderd uit de database");
        return "bevestigingspagina";
    }

    @RequestMapping(value = {"/updatetraject-{trajectId}"}, method = RequestMethod.POST, params = "verwijdermodule")
    public String verwijderModule(@PathVariable int trajectId, @RequestParam(value = "verwijdermodule") int moduleId, Traject traject, ModelMap model) {
        System.out.println("Exterminate" + " " + moduleId);
        traject.setModules(trajectService.read(trajectId).getModules());
        model.addAttribute("traject", traject);

        return "wijzigtraject";
    }

    @RequestMapping(value = {"nieuwtraject"}, method = RequestMethod.GET)
    public String nieuwTrajectGet(Traject traject, ModelMap model) {
        
          
        model.addAttribute("traject", traject);
      
        return "nieuwtraject";
    }

    @RequestMapping(value = {"nieuwtraject"}, method = RequestMethod.POST)
    public String saveTraject(@Valid Traject traject, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "nieuwtraject";
        }
   
        trajectService.create(traject);
        model.addAttribute("succes", traject.getNaam() + ": "
                + traject.getOmschrijving()+ " staat geregistreerd");
        return "bevestigingspagina";
    }

}
