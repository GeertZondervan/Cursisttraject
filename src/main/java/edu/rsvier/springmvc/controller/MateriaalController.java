package edu.rsvier.springmvc.controller;

import edu.rsvier.springmvc.model.Expertise;
import edu.rsvier.springmvc.model.Materiaal;
import edu.rsvier.springmvc.model.Module;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.rsvier.springmvc.service.MateriaalService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/materialen")
public class MateriaalController {

    @Autowired
    MateriaalService materiaalService;

    // Materiaaloverzicht
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String listMaterialen(ModelMap model) {

        List<Materiaal> materialen = materiaalService.getAll();

        model.addAttribute("materialen", materialen);
        return "Materiaaldomein/materiaaloverzicht";
    }

    @RequestMapping(value = {"/nieuwmateriaal"}, method = RequestMethod.GET)
    public String nieuwMateriaalGet(Materiaal materiaal, ModelMap model) {
        List<Materiaal> materialen = materiaalService.getAll();
        model.addAttribute("materialen", materialen);

        return "Materiaaldomein/nieuwmateriaal";
    }

    @RequestMapping(value = {"/nieuwmateriaal"}, method = RequestMethod.POST)
    public String nieuwMateriaalPost(@ModelAttribute("materiaal") Materiaal materiaal, BindingResult result, ModelMap model) {
        System.out.println(materiaal);

        materiaalService.create(materiaal);

        model.addAttribute("succes", "Het materiaal " + materiaal.getTitel() + " is toegevoegd");
        return "Algemeen/bevestigingspagina";
    }

    @RequestMapping(value = {"/update-materiaal-{materiaalId}"}, method = RequestMethod.GET)
    public String wijzigMateriaalGet(@PathVariable int materiaalId, @ModelAttribute("materiaal") Materiaal materiaal, BindingResult result, ModelMap model) {
        materiaal = materiaalService.read(materiaalId);
        model.addAttribute("materiaal", materiaal);

        return "Materiaaldomein/wijzigmateriaal";
    }

    @RequestMapping(value = {"/update-materiaal-{materiaalId}"}, method = RequestMethod.POST)
    public String wijzigMateriaalPost(@PathVariable int materiaalId, @ModelAttribute("materiaal") Materiaal materiaal, BindingResult result, ModelMap model) {
        materiaalService.update(materiaal);
        model.addAttribute("succes", "Het materiaal " + materiaal.getOmschrijving() + " is gewijzigd");
        return "Algemeen/bevestigingspagina";
    }
    
    @RequestMapping(value = {"/delete-materiaal-{materiaalId}"}, method = RequestMethod.GET)
    public String deleteMateriaalGet(@PathVariable int materiaalId, @ModelAttribute("materiaal") Materiaal materiaal, BindingResult result, ModelMap model) {
        materiaal = materiaalService.read(materiaalId);
        model.addAttribute("materiaal", materiaal);

        return "Materiaaldomein/verwijdermateriaal";
    }

    @RequestMapping(value = {"/delete-materiaal-{materiaalId}"}, method = RequestMethod.POST)
    public String deleteMateriaalPost(@PathVariable int materiaalId, @ModelAttribute("materiaal") Materiaal materiaal, BindingResult result, ModelMap model) {
      
        materiaalService.delete(materiaal);
        
        model.addAttribute("succes", "Het materiaal " + materiaal.getOmschrijving() + " is verwijderd");
        return "Algemeen/bevestigingspagina";
    }
}
