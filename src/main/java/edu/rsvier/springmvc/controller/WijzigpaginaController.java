/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rsvier.springmvc.controller;

import edu.rsvier.springmvc.model.Persoon;
import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.PersoonsrolId;
import edu.rsvier.springmvc.model.Rol;
import edu.rsvier.springmvc.service.PersoonService;
import edu.rsvier.springmvc.service.PersoonsrolService;
import edu.rsvier.springmvc.service.RolService;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WijzigpaginaController {

    @Autowired
    PersoonService service;

    @Autowired
    RolService rolService;

    @Autowired
    PersoonsrolService persoonsrolService;

    @RequestMapping(value = {"/update-{persoonid}"}, method = RequestMethod.GET)
    public String getPersoon(@PathVariable int persoonid, Persoon persoon, ModelMap model) {
        persoon = service.read(persoonid);
        List<Rol> rollen = rolService.getAll();
        model.addAttribute("persoon", persoon);
        model.addAttribute("rollen", rollen);
        return "wijzig";
    }

    @RequestMapping(value = {"/update-{persoonid}"}, method = RequestMethod.POST)
    public String wijzigPersoonPost(@PathVariable int persoonid, Persoon persoon, ModelMap model) {
        Persoon persoonRead = service.read(persoonid);
        persoonRead = persoon;
        persoonRead.setId(persoonid);
        service.update(persoon);

        model.addAttribute("succes", persoon.getVoornaam() + " "
                + persoon.getAchternaam() + " is gewijzigd");
        return "bevestigingspagina";
    }

    @RequestMapping(value = {"/update-{persoonid}"}, method = RequestMethod.POST, params = "verwijderpersoonsrol")
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

        return getPersoon(persoonid, persoon, model);
    }

}
