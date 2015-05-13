/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rsvier.springmvc.controller;

import edu.rsvier.springmvc.model.Persoon;
import edu.rsvier.springmvc.model.PersoonRolPaginaData;
import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.PersoonsrolId;
import edu.rsvier.springmvc.model.Rol;
import edu.rsvier.springmvc.service.PersoonService;
import edu.rsvier.springmvc.service.PersoonsrolService;
import edu.rsvier.springmvc.service.RolService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersoonsrollenWijzigController {

    @Autowired
    PersoonService service;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    PersoonsrolService persoonsrolService;
    
    @RequestMapping(value = {"{persoonid}-persoonsrollen"}, method = RequestMethod.GET)
    public String getPersoon(@PathVariable int persoonid, PersoonRolPaginaData persoonRolData, ModelMap model) {
        Persoon persoon = service.read(persoonid);
        List<Rol>rollen = rolService.getAll();
        List<String>rolnamen = new ArrayList<String>();
        for(Rol rol: rollen){
            rolnamen.add(rol.getNaam());
        }
        persoonRolData.setPersoon(persoon);
        model.addAttribute("rolnamen", rolnamen);
        model.addAttribute("persoonroldata", persoonRolData);
        
       
        return "persoonsrollenwijzigen";
    }
    
    @RequestMapping(value = {"{persoonid}-persoonsrollen"}, method = RequestMethod.POST)
    public String wijzigPersoonPost(@PathVariable int persoonid, PersoonRolPaginaData persoonRolData, ModelMap model) {
        Persoon persoon = service.read(persoonid);
        System.out.println(persoon.getPersoonsrollen());
        
        List<String> rollenDezePersoon = persoonRolData.getPersoonsrolnamen();
        System.out.println(rollenDezePersoon);
        
        for(String rolNaam:rollenDezePersoon){
            Rol rol = rolService.read(rolNaam);
            Persoonsrol persoonsrol = new Persoonsrol();
            persoonsrol.setPersoon(persoon);
            persoonsrol.setRol(rol);
            
            if(!persoon.getPersoonsrollen().contains(persoonsrol)){
                PersoonsrolId persoonsrolId = new PersoonsrolId();
                persoonsrolId.setPersoonId(persoonid);
                persoonsrolId.setRolId(rol.getId());
                persoonsrolId.setBegindatum(LocalDate.now());
                persoonsrol.setId(persoonsrolId);
                persoonsrolService.create(persoonsrol);

                persoon.getPersoonsrollen().add(persoonsrol);
            }
            service.update(persoon);
        }
        
         model.addAttribute("succes", persoon.getVoornaam() + " "
                + persoon.getAchternaam() + " is gewijzigd");
        return "redirect: /update-{persoonid}";
    }
    
   
    
    

}

