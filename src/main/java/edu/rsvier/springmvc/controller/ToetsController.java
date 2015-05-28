package edu.rsvier.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.rsvier.springmvc.model.Expertise;
import edu.rsvier.springmvc.model.Module;
import edu.rsvier.springmvc.service.ExpertiseService;
import edu.rsvier.springmvc.service.ModuleService;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/expertises")
public class ToetsController {

    @Autowired
    ExpertiseService expertiseService;

    @Autowired
    ModuleService moduleService;

    @RequestMapping(value = {"", "/expertiselijst"}, method = RequestMethod.GET)
    public String listPersonen(ModelMap model) {

        List<Expertise> expertises = expertiseService.getAll();

        model.addAttribute("expertises", expertises);
        return "expertiseoverzicht";
    }

    @RequestMapping(value = {"/nieuwe-expertise"}, method = RequestMethod.GET)
    public String nieuweExpertiseGet(Expertise expertise, ModelMap model) {
        List<Module> modules = moduleService.getAll();
        System.out.println(modules);
        model.addAttribute("modules", modules);
        model.addAttribute("expertise", expertise);

        return "nieuweexpertise";
    }

    @RequestMapping(value = {"/nieuwe-expertise"}, method = RequestMethod.POST)
    public String nieuweExpertisePost(Expertise expertise, ModelMap model) {
        System.out.println(expertise);
        try {
            System.out.println(expertise.getModule().getId());
        } catch (Exception ex) {
            expertise.setModule(null);
        }
        expertiseService.create(expertise);

        model.addAttribute("expertise", expertise);
        model.addAttribute("succes", "De expertise " + expertise.getNaam() + " is toegevoegd");
        return "bevestigingspagina";
    }

    @RequestMapping(value = {"/delete-expertise-{expertiseId}"}, method = RequestMethod.GET)
    public String deleteExpertiseGet(@PathVariable int expertiseId, Expertise expertise, ModelMap model) {
        expertise = expertiseService.read(expertiseId);
        model.addAttribute("expertise", expertise);
        return "verwijderexpertise";
    }

    @RequestMapping(value = {"/delete-expertise-{expertiseId}"}, method = RequestMethod.POST)
    public String deleteExpertisePost(@PathVariable int expertiseId, Expertise expertise, ModelMap model) {
        expertiseService.delete(expertiseService.read(expertiseId));
        model.addAttribute("succes", "Deze expertise is succesvol verwijderd");
        return "bevestigingspagina";
    }

    @RequestMapping(value = {"/update-expertise-{expertiseId}"}, method = RequestMethod.GET)
    public String wijzigExpertiseGet(@PathVariable int expertiseId, Expertise expertise, ModelMap model) {
        expertise = expertiseService.read(expertiseId);
        model.addAttribute("expertise", expertise);
        return "wijzigexpertise";
    }

    @RequestMapping(value = {"/update-expertise-{expertiseId}"}, method = RequestMethod.POST)
    public String wijzigExpertisePost(@PathVariable int expertiseId, Expertise expertise, ModelMap model) {
        Expertise expertiseRead = expertiseService.read(expertiseId);
        expertiseRead = expertise;
        expertiseRead.setId(expertiseId);
        expertiseService.update(expertise);

        model.addAttribute("succes", "De Expertise " + expertise.getOmschrijving() + " is gewijzigd");
        return "bevestigingspagina";
    }

}
