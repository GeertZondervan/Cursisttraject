package edu.rsvier.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.rsvier.springmvc.model.Persoon;

import edu.rsvier.springmvc.service.PersoonService;

@Controller
@RequestMapping({"/", "/list"})
public class PersoonslijstController {

    @Autowired
    PersoonService service;

    @RequestMapping(method = RequestMethod.GET)
    public String listPersonen(ModelMap model) {

        List<Persoon> personen = service.getAll();
        model.addAttribute("personen", personen);
        return "start";
    }

    @RequestMapping(value = {"/registratie"}, method = RequestMethod.GET)
    public String newPersoon(Persoon persoon, ModelMap model) {

        model.addAttribute("persoon", persoon);
        return "registratie";
    }

//    /*
//     * This method will provide the medium to add a new employee.
//     */
//    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
//    public String newPersoon(Persoon persoon, ModelMap model) {
//
//        model.addAttribute("persoon", persoon);
//        return "registration";
//    }
//
//    /*
//     * This method will provide the medium to add a new employee.
//     */
//    @RequestMapping(value = {"/update-{id} "}, method = RequestMethod.GET)
//    public String updatePersoon(@PathVariable int id, Persoon persoon, ModelMap model) {
//
//        persoon = service.read(id);
//
//        model.addAttribute("persoon", persoon);
//        System.out.println("Adresid in de getter: " + persoon.getAdres().getId());
//
//        return "wijzig";
//    }
//
//    @RequestMapping(value = {"/update-{id} "}, method = RequestMethod.POST)
//    public String update1Persoon(@PathVariable int id, @Valid Persoon persoon, BindingResult result,
//            ModelMap model) {
//
//        if (result.hasErrors()) {
//            return "wijzig";
//        }
//
//        service.updatePersoon(persoon);
//
//        model.addAttribute("geupdate", "Persoon " + persoon.getVoornaam() + " "
//                + persoon.getAchternaam() + " is gewijzigd");
//        return "updatecompleet";
//    }
//
//    @RequestMapping(value = {"/delete-{id}"}, method = RequestMethod.GET)
//    public String deletePersoon(@PathVariable int id, ModelMap model) {
//        Persoon persoon = service.read(id);
//        model.addAttribute("persoon", persoon);
//        return "verwijder";
//    }
//
//    @RequestMapping(value = {"/delete-{id}"}, method = RequestMethod.POST)
//    public String delete1Persoon(@PathVariable int id, @Valid Persoon persoon, BindingResult result,
//            ModelMap model) {
//
//        if (result.hasErrors()) {
//            return "wijzig";
//        }
//        service.deletePersoon(persoon.getVoornaam(), persoon.getAchternaam());
//
//        model.addAttribute("geupdate", "Persoon " + persoon.getVoornaam() + " "
//                + persoon.getAchternaam() + " is gewijzigd");
//        return "updatecompleet";
//    }
//
//    /*
//     * This method will be called on form submission, handling POST request for
//     * saving employee in database. It also validates the user input
//     */
//    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
//    public String savePersoon(@Valid Persoon persoon, BindingResult result,
//            ModelMap model) {
//
//        if (result.hasErrors()) {
//            return "registration";
//        }
//        //adresService.createAdres(persoon.getAdres());
//        service.createPersoon(persoon);
//
//        model.addAttribute("succes", "Persoon " + persoon.getVoornaam() + " "
//                + persoon.getAchternaam() + " staat geregistreerd");
//        return "success";
//    }
//
//    /*
//     * This method will delete an employee by it's SSN value.
//     */
//    
//
//    @RequestMapping(value = {"/resultaten-{id}"}, method = RequestMethod.POST, params = "verwijder")
//    public String verwijderResultaat(@RequestParam(value = "verwijder") int resultaatId, Persoon persoon, ModelMap model) {
//        System.out.println("Methode is gekoppeld" + resultaatId);
//        resultaatService.deleteResultaat(resultaatService.read(resultaatId));
//        return resultatenPersoonGet(persoon.getId(), persoon, model);
//    }
//    
//       @RequestMapping(value = {"/resultaten-{id}"}, method = RequestMethod.POST, params = "voegtoe")
//    public String voegToeResultaat(@RequestParam(value = "voegtoe") int id, Resultaat resultaat, Persoon persoon, ModelMap model) {
//        System.out.println("Persoon gekoppeld aan resultaat: " + id);
//        System.out.println(persoon);
//        persoon = service.read(id);
//        persoon.getResultaten().add(resultaat);
//        System.out.println(resultaat);
//        resultaat.setPersoon(persoon);
//        resultaatService.createResultaat(resultaat);
//        service.updatePersoon(persoon);
//        
//        
//        return resultatenPersoonGet(persoon.getId(), persoon, model);
//    }
//    
//
//    @RequestMapping(value = {"/resultaten-{id}"}, method = RequestMethod.GET)
//    public String resultatenPersoonGet(@PathVariable int id, Persoon persoon, ModelMap model) {
//        persoon = service.read(id);
//        model.addAttribute("persoon", persoon);
//        List<Resultaat> resultaten = persoon.getResultaten();
//        model.addAttribute("resultaten", resultaten);
//        Resultaat resultaat = new Resultaat();
//        model.addAttribute("resultaat", resultaat);
//        return "resultatenpagina";
//    }
}
