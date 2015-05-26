package edu.rsvier.springmvc.controller;

import edu.rsvier.springmvc.model.Persoon;
import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.Rol;
import edu.rsvier.springmvc.service.PersoonService;
import edu.rsvier.springmvc.service.PersoonsrolService;
import edu.rsvier.springmvc.service.RolService;
import java.util.List;
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
    
//    @RequestMapping(value = {"{persoonid}-persoonsroltoevoegen"}, method = RequestMethod.GET)
//    public String getPersoon(@PathVariable int persoonid, ModelMap model) {
//        Persoon persoon = service.read(persoonid);
//        Persoonsrol persoonsrol = new Persoonsrol();
//        persoonsrol.setPersoon(persoon);
//        List<Rol>rollen = rolService.getAll();
//        model.addAttribute("rollen", rollen);
//        model.addAttribute("persoonsrol", persoonsrol);
//        model.addAttribute("persoon", persoon);
//        return "persoonsroltoevoegen";
//    }
//    
//    @RequestMapping(value = {"{persoonid}-persoonsroltoevoegen"}, method = RequestMethod.POST)
//    public String wijzigPersoonPost(@PathVariable int persoonid, Persoonsrol persoonsrol, ModelMap model) {
//        Persoon persoon = service.read(persoonid);
//        System.out.println(persoon.getPersoonsrollen());
//         model.addAttribute("succes", persoon.getVoornaam() + " "
//                + persoon.getAchternaam() + " is gewijzigd");
//        return "redirect: /update-{persoonid}";
//    }
//    
   
    
    

}

