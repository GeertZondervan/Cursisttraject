package edu.rsvier.springmvc.controller;

import edu.rsvier.springmvc.model.Module;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.rsvier.springmvc.model.Toets;
import edu.rsvier.springmvc.model.ToetsResultaat;
import edu.rsvier.springmvc.service.ModuleService;
import edu.rsvier.springmvc.service.ToetsResultaatService;
import edu.rsvier.springmvc.service.ToetsService;
import java.util.Set;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/toetsen")
public class ToetsController {

    @Autowired
    ToetsService toetsService;
    
    @Autowired
    ModuleService moduleService;
    
    @Autowired
    ToetsResultaatService toetsResultaatService;


    @RequestMapping(value = {"", "/toetslijst"}, method = RequestMethod.GET)
    public String listToetsen(ModelMap model) {

        List<Toets> toetsen = toetsService.getAll();

        model.addAttribute("toetsen", toetsen);
        return "toetsoverzicht";
    }

    @RequestMapping(value = {"/nieuwetoets"}, method = RequestMethod.GET)
    public String nieuweToetsGet(Toets toets, ModelMap model) {
        List<Module> modules = moduleService.getAll();
        model.addAttribute("modules", modules);
        model.addAttribute("toets", toets);

        return "nieuwetoets";
    }
    
    @RequestMapping(value = {"/toets-resultaten-{toetsId}"}, method = RequestMethod.GET)
    public String toetsResultatenGet(@PathVariable int toetsId, Toets toets, ModelMap model) {
        toets = toetsService.read(toetsId);
       
        model.addAttribute("toets", toets);
        System.out.println(toets.getToetsResultaten());
        
       
       
        return "toetsresultatenoverzicht";
    }

    @RequestMapping(value = {"/nieuwetoets"}, method = RequestMethod.POST)
    public String nieuweToetsPost(Toets toets, ModelMap model) {
       
        toetsService.create(toets);

        model.addAttribute("toets", toets);
        model.addAttribute("succes", "De toets " + toets.getNaam() + " is toegevoegd");
        return "bevestigingspagina";
    }

    @RequestMapping(value = {"/delete-toets-{toetsId}"}, method = RequestMethod.GET)
    public String deleteToetsGet(@PathVariable int toetsId, Toets toets, ModelMap model) {
        toets = toetsService.read(toetsId);
        model.addAttribute("toets", toets);
        return "verwijdertoets";
    }

    @RequestMapping(value = {"/delete-toets-{toetsId}"}, method = RequestMethod.POST)
    public String deleteToetsPost(@PathVariable int toetsId, Toets toets, ModelMap model) {
        toetsService.delete(toetsService.read(toetsId));
        model.addAttribute("succes", "Deze toets is succesvol verwijderd uit de database");
        return "bevestigingspagina";
    }

    @RequestMapping(value = {"/update-toets-{toetsId}"}, method = RequestMethod.GET)
    public String wijzigToetsGet(@PathVariable int toetsId, Toets toets, ModelMap model) {
        List<Module> modules = moduleService.getAll();
        model.addAttribute("modules", modules);
        toets = toetsService.read(toetsId);
        model.addAttribute("toets", toets);
        return "wijzigtoets";
    }

    @RequestMapping(value = {"/update-toets-{toetsId}"}, method = RequestMethod.POST)
    public String wijzigToetsPost(@PathVariable int toetsId, Toets toets, ModelMap model) {
        Toets toetsRead = toetsService.read(toetsId);
        toetsRead = toets;
        toetsRead.setId(toetsId);
        toetsService.update(toets);

        model.addAttribute("succes", "De toets " + toets.getNaam() + ": " + toets.getOmschrijving() + " is gewijzigd");
        return "bevestigingspagina";
    }

}
