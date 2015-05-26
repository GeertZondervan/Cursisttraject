package edu.rsvier.springmvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.rsvier.springmvc.model.Persoon;
import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.PersoonsrolId;
import edu.rsvier.springmvc.model.Rol;
import edu.rsvier.springmvc.service.PersoonService;
import edu.rsvier.springmvc.service.PersoonsrolService;
import edu.rsvier.springmvc.service.RolService;
import edu.rsvier.springmvc.service.ToetsResultaatService;
import java.time.LocalDate;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/personen")
public class PersoonslijstController {

    @Autowired
    PersoonService service;

    @Autowired
    RolService rolService;

    @Autowired
    PersoonsrolService persoonsrolService;

    @Autowired
    ToetsResultaatService resultaatService;

    @RequestMapping(value = {"", "lijst"}, method = RequestMethod.GET)
    public String listPersonen(ModelMap model) {
        List<Persoon> personen = service.getAll();
        model.addAttribute("personen", personen);
        return "personenlijst";
    }

    @RequestMapping(value = {"update-{persoonid}"}, method = RequestMethod.GET)
    public String getPersoon(@PathVariable int persoonid, Persoon persoon, ModelMap model) {
        persoon = service.read(persoonid);
        List<Rol> rollen = rolService.getAll();
        model.addAttribute("persoon", persoon);
        model.addAttribute("rollen", rollen);
        return "wijzig";
    }

    @RequestMapping(value = {"update-{persoonid}"}, method = RequestMethod.POST)
    public String wijzigPersoonPost(@PathVariable int persoonid, @Valid Persoon persoon, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            persoon.setPersoonsrollen(service.read(persoonid).getPersoonsrollen());
            persoon.setExpertises(service.read(persoonid).getExpertises());
            model.addAttribute("persoon", persoon);
            return "wijzig";
        } else {

            Persoon persoonRead = service.read(persoonid);
            persoonRead = persoon;
            persoonRead.setId(persoonid);
            service.update(persoon);

            model.addAttribute("succes", persoon.getVoornaam() + " "
                    + persoon.getAchternaam() + " is gewijzigd");
            return "bevestigingspagina";
        }
    }

    @RequestMapping(value = {"update-{persoonid}"}, method = RequestMethod.POST, params = "verwijderpersoonsrol")
    public String verwijderPersoonsrol(@PathVariable int persoonid, @RequestParam(value = "verwijderpersoonsrol") int rolId, ModelMap model) {

        Persoon persoon = service.read(persoonid);
        System.out.println("ID: " + persoon.getId());

        Persoonsrol persoonsrol = persoonsrolService.read(persoonid, rolId);
        PersoonsrolId persoonsrolId = persoonsrol.getId();
        System.out.println("Persoonsrolid: " + persoonsrolId);
        if (persoon.getPersoonsrollen().contains(persoonsrol)) {
            persoon.getPersoonsrollen().remove(persoonsrol);
        } else {
            System.out.println("persoonsrol not found");
        }

        persoonsrolService.delete(persoonsrol);
        service.update(persoon);

        return "wijzig";
    }

    @RequestMapping(value = {"delete-{persoonid}"}, method = RequestMethod.GET)
    public String deletePersoonGet(@PathVariable int persoonid, Persoon persoon, ModelMap model) {
        persoon = service.read(persoonid);
        model.addAttribute("persoon", persoon);
        return "verwijder";
    }

    @RequestMapping(value = {"delete-{persoonid}"}, method = RequestMethod.POST)
    public String deletePersoonPost(@PathVariable int persoonid, Persoon persoon, ModelMap model) {
        service.delete(service.read(persoonid));
        model.addAttribute("succes", "Deze persoon is succesvol verwijderd");
        return "bevestigingspagina";
    }

    @RequestMapping(value = {"nieuwpersoon"}, method = RequestMethod.GET)
    public String newPersoon(Persoon persoon, ModelMap model) {

        model.addAttribute("persoon", persoon);
        return "registratie";
    }

    @RequestMapping(value = {"nieuwpersoon"}, method = RequestMethod.POST)
    public String savePersoon(@Valid Persoon persoon, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "registratie";
        }

        service.create(persoon);
        model.addAttribute("succes", persoon.getVoornaam() + " "
                + persoon.getAchternaam() + " staat geregistreerd");
        return "bevestigingspagina";
    }

    @RequestMapping(value = {"{persoonid}-persoonsroltoevoegen"}, method = RequestMethod.GET)
    public String persoonsRolToevoegenGet(@PathVariable int persoonid, ModelMap model) {
        Persoon persoon = service.read(persoonid);
        Persoonsrol persoonsrol = new Persoonsrol();
        persoonsrol.setPersoon(persoon);
        List<Rol> rollen = rolService.getAll();
        model.addAttribute("rollen", rollen);
        model.addAttribute("persoonsrol", persoonsrol);
        model.addAttribute("persoon", persoon);
        return "persoonsroltoevoegen";
    }

    @RequestMapping(value = {"{persoonid}-persoonsroltoevoegen"}, method = RequestMethod.POST, params = "nieuwepersoonsrol")
    public String persoonsRolToevoegenPost(@PathVariable int persoonid, @RequestParam(value = "nieuwepersoonsrol") int rolId, @Valid Persoon persoon, BindingResult result, ModelMap model) {
        System.out.println(rolId);
        System.out.println(persoonid);
        System.out.println(persoon);
        
        PersoonsrolId persoonsrolId = new PersoonsrolId();
        persoonsrolId.setPersoonId(persoonid);
        persoonsrolId.setRolId(rolId);
        persoonsrolId.setBegindatum(LocalDate.now());
        
        
        persoon = service.read(persoonid);
        Persoonsrol persoonsrol = new Persoonsrol();
        persoonsrol.setPersoon(persoon);
        persoonsrol.setRol(rolService.read(rolId));
        persoonsrol.setId(persoonsrolId);
        persoonsrolService.create(persoonsrol);
        
        persoon.getPersoonsrollen().add(persoonsrol);
        service.update(persoon);
        
        
        
        
        return "wijzig";
    }

//    @RequestMapping(value = {"/resultaten-{id}"}, method = RequestMethod.GET)
//    public String resultatenPersoonGet(@PathVariable int id, Persoon persoon, ModelMap model) {
//        persoon = service.read(id);
//        model.addAttribute("persoon", persoon);
//        ToetsResultaat resultaat = persoon.getPersoonsrollen().
//        List<ToetsResultaat> resultaten = persoon.getPersoonsrollen().get(0).get;
//        model.addAttribute("resultaten", resultaten);
//        Resultaat resultaat = new Resultaat();
//        model.addAttribute("resultaat", resultaat);
//        return "resultatenpagina";
//    }
//
//    @RequestMapping(value = {"/resultaten-{id}"}, method = RequestMethod.POST, params = "verwijder")
//    public String verwijderResultaat(@RequestParam(value = "verwijder") int resultaatId, Persoon persoon, ModelMap model) {
//        System.out.println("Methode is gekoppeld" + resultaatId);
//        resultaatService.deleteResultaat(resultaatService.read(resultaatId));
//        return resultatenPersoonGet(persoon.getId(), persoon, model);
//    }
//
//    @RequestMapping(value = {"/resultaten-{id}"}, method = RequestMethod.POST, params = "voegtoe")
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
//        return resultatenPersoonGet(persoon.getId(), persoon, model);
//    }
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
}
