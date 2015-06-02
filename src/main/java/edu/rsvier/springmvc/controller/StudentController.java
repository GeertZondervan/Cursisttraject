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
import java.util.ArrayList;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/studenten")
public class StudentController {

    @Autowired
    PersoonService persoonService;

    @Autowired
    RolService rolService;

    @Autowired
    PersoonsrolService persoonsrolService;

    @Autowired
    ToetsResultaatService resultaatService;

    @RequestMapping(value = {"", "lijst"}, method = RequestMethod.GET)
    public String listStudenten(ModelMap model) {
        List<Persoonsrol>studentenRollen = persoonsrolService.getAllWithRol("Student");
        model.addAttribute("studentenrollen", studentenRollen);
        return "Studentdomein/studentenlijst";
    }
    
    @RequestMapping(value = {"update-{persoonid}-{rolid}"}, method = RequestMethod.GET)
    public String getPersoon(@PathVariable int persoonid, @PathVariable int rolid, @ModelAttribute("persoonsrol") Persoonsrol persoonsrol, BindingResult result, ModelMap model) {
        persoonsrol=persoonsrolService.read(persoonid, rolid);
        model.addAttribute("persoonsrol", persoonsrol);
        return "Studentdomein/wijzigstudent";
    }
}