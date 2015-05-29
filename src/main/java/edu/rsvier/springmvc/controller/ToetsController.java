package edu.rsvier.springmvc.controller;

import edu.rsvier.springmvc.model.Module;
import edu.rsvier.springmvc.model.Persoon;
import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.PersoonsrolId;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.rsvier.springmvc.model.Toets;
import edu.rsvier.springmvc.model.ToetsResultaat;
import edu.rsvier.springmvc.model.ToetsResultaatId;
import edu.rsvier.springmvc.service.ModuleService;
import edu.rsvier.springmvc.service.PersoonService;
import edu.rsvier.springmvc.service.PersoonsrolService;
import edu.rsvier.springmvc.service.RolService;
import edu.rsvier.springmvc.service.ToetsResultaatService;
import edu.rsvier.springmvc.service.ToetsService;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/toetsen")
public class ToetsController {
    
    @Autowired
    PersoonService persoonService;
    
    @Autowired
    ToetsService toetsService;
    
    @Autowired
    ModuleService moduleService;
    
    @Autowired
    ToetsResultaatService toetsResultaatService;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    PersoonsrolService persoonsrolService;
    
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
    
    @RequestMapping(value = {"/{toetsId}/nieuwtoetsresultaat"}, method = RequestMethod.GET)
    public String nieuwToetsresultaatGet(@PathVariable int toetsId, ToetsResultaat toetsResultaat, ModelMap model) {
        
        toetsResultaat = new ToetsResultaat();
        toetsResultaat.setDatum(LocalDate.now());
        toetsResultaat.setToets(toetsService.read(toetsId));
        
        toetsResultaat.setId(new ToetsResultaatId());
        toetsResultaat.getId().setPersoonsrolRolId(rolService.read("Student").getId());
        
        Toets toets = toetsService.read(toetsId);

        // Lijst genereren voor dropdown op pagina met alleen personen die deze nog niet gemaakt hebben
        List<Persoon> personenAlGemaakt = new ArrayList<Persoon>();
        for (ToetsResultaat resultaat : toets.getToetsResultaten()) {
            personenAlGemaakt.add(resultaat.getPersoonsrol().getPersoon());
        }
        List<Persoon> personenNogNietGemaakt = persoonService.getAll();
        personenNogNietGemaakt.removeAll(personenAlGemaakt);

        // Verdere selectie: alleen personen met de rol student in de dropdown
        List<Persoon> studenten = new ArrayList<Persoon>();
        for (Persoon persoon : personenNogNietGemaakt) {
            for (Persoonsrol persoonsrolInPersoon : persoon.getPersoonsrollen()) {
                if (persoonsrolInPersoon.getRol().getNaam().equals("Student")) {
                    studenten.add(persoon);
                }
            }
        }
        personenNogNietGemaakt.retainAll(studenten);
        
        model.addAttribute("rollen", rolService.getAll());
        model.addAttribute("personen", personenNogNietGemaakt);
        model.addAttribute("toetsresultaat", toetsResultaat);
        
        return "nieuwtoetsresultaat";
    }
    
    @RequestMapping(value = {"/{toetsId}/nieuwtoetsresultaat"}, method = RequestMethod.POST)
    public String nieuwToetsresultaatPost(@PathVariable int toetsId, ToetsResultaat toetsResultaat, ModelMap model) {
        
        toetsResultaat.setToets(toetsService.read(toetsId));
        toetsResultaat.setPersoonsrol(persoonsrolService.read(toetsResultaat.getId().getPersoonsrolPersoonId(), rolService.read("Student").getId()));

        //ToetsresultaatId setten:
        toetsResultaat.getId().setPersoonsrolBegindatum(toetsResultaat.getPersoonsrol().getId().getBegindatum());
        toetsResultaat.getId().setPersoonsrolRolId(toetsResultaat.getPersoonsrol().getId().getRolId());
        toetsResultaat.getId().setPersoonsrolPersoonId(toetsResultaat.getPersoonsrol().getId().getPersoonId());
        
        toetsResultaat.getId().setToetsId(toetsId);
        toetsResultaatService.create(toetsResultaat);
        
        return "bevestigingspagina";
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
    
    @RequestMapping(value = {"/update-toetsresultaat-{toetsId}-{persoonId}"}, method = RequestMethod.GET)
    public String wijzigToetsresultaatGet(@PathVariable int toetsId, @PathVariable int persoonId, @ModelAttribute("toetsresultaat") ToetsResultaat toetsResultaat, BindingResult result, ModelMap model) {
        Persoonsrol persoonsrol;
        persoonsrol = persoonsrolService.read(persoonId, rolService.read("Student").getId());
        System.out.println(persoonsrol);
        
        ToetsResultaatId toetsResultaatId = new ToetsResultaatId();
        toetsResultaatId.setPersoonsrolBegindatum(persoonsrol.getId().getBegindatum());
        toetsResultaatId.setPersoonsrolPersoonId(persoonsrol.getId().getPersoonId());
        toetsResultaatId.setPersoonsrolRolId(persoonsrol.getId().getRolId());
        toetsResultaatId.setToetsId(toetsId);
        System.out.println("Resultaat: " + toetsResultaatId);
        
        toetsResultaat = toetsResultaatService.read(toetsResultaatId);
        toetsResultaat.setId(toetsResultaatId);
        model.addAttribute("toetsresultaat", toetsResultaat);
        model.addAttribute("toetsresultaat.id", toetsResultaat.getId());
        
        return "wijzigtoetsresultaat";
    }
    
    @RequestMapping(value = {"/update-toetsresultaat-{toetsId}-{persoonId}"}, method = RequestMethod.POST)
    public String wijzigToetsresultaatPost(@PathVariable int toetsId, @PathVariable int persoonId, @ModelAttribute("toetsresultaat") ToetsResultaat toetsResultaat,BindingResult result, ModelMap model) {
        
        ToetsResultaat toetsResultaatRead = toetsResultaatService.read(persoonId, toetsId);
        toetsResultaatRead.setDatum(toetsResultaat.getDatum());
        toetsResultaatRead.setResultaat(toetsResultaat.getResultaat());
        
        System.out.println(toetsResultaatRead);
        System.out.println(toetsResultaatRead.getId());
        
        toetsResultaatService.update(toetsResultaatRead);
        
        return "bevestigingspagina";
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
