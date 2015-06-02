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
    public String listPersonen(ModelMap model) {
        
        List<Persoon> studenten = persoonService.getWithRol("Student");
        
        
        model.addAttribute("personen", studenten);
        return "Studentdomein/studentenlijst";
    }
}