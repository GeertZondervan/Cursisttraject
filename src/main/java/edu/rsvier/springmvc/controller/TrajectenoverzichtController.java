package edu.rsvier.springmvc.controller;

import edu.rsvier.springmvc.model.Module;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.rsvier.springmvc.model.Traject;
import edu.rsvier.springmvc.service.ModuleService;
import edu.rsvier.springmvc.service.TrajectService;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/trajecten")
public class TrajectenoverzichtController {

    @Autowired
    TrajectService trajectService;

    @Autowired
    ModuleService moduleService;

    @RequestMapping(value = {"", "/trajectenlijst"}, method = RequestMethod.GET)
    public String listPersonen(ModelMap model) {

        List<Traject> trajecten = trajectService.getAll();
        model.addAttribute("trajecten", trajecten);
        return "Trajectdomein/trajectenoverzicht";
    }

    @RequestMapping(value = {"/updatetraject-{trajectId}"}, method = RequestMethod.GET)
    public String wijzigTrajectGet(@PathVariable int trajectId, Traject traject, ModelMap model) {
        traject = trajectService.read(trajectId);
        model.addAttribute("traject", traject);
        return "Trajectdomein/wijzigtraject";
    }

    @RequestMapping(value = {"/updatetraject-{trajectId}"}, method = RequestMethod.POST)
    public String wijzigTrajectPost(@PathVariable int trajectId, Traject traject, ModelMap model) {
        Traject trajectRead = trajectService.read(trajectId);

        trajectRead = traject;
        trajectRead.setId(trajectId);
        trajectService.update(traject);
        model.addAttribute("succes, Traject", traject.getNaam() + " "
                + "is gewijzigd");
        return "Algemeen/bevestigingspagina";

    }

    @RequestMapping(value = {"delete-{trajectId}"}, method = RequestMethod.GET)
    public String deleteTrajectGet(@PathVariable int trajectId, Traject traject, ModelMap model) {
        traject = trajectService.read(trajectId);
        model.addAttribute("traject", traject);
        return "Trajectdomein/verwijdertraject";
    }

    @RequestMapping(value = {"delete-{trajectId}"}, method = RequestMethod.POST)
    public String deleteTrajectPost(@PathVariable int trajectId, Traject traject, ModelMap model) {
        trajectService.delete(trajectService.read(trajectId));
        model.addAttribute("succes", "Dit traject is succesvol verwijderd uit de database");
        return "Algemeen/bevestigingspagina";
    }

//    @RequestMapping(value = {"/updatetraject-{trajectId}"}, method = RequestMethod.POST, params = "verwijdermodule")
//    public String verwijderModule(@PathVariable int trajectId, @RequestParam(value = "verwijdermodule") int moduleId, Traject traject, ModelMap model) {
//        System.out.println("Exterminate" + " " + moduleId);
//        traject.setModules(trajectService.read(trajectId).getModules());
//        model.addAttribute("traject", traject);
//
//        return "wijzigtraject";
//    }

    @RequestMapping(value = {"nieuwtraject"}, method = RequestMethod.GET)
    public String nieuwTrajectGet(Traject traject, ModelMap model) {

        model.addAttribute("traject", traject);

        return "Trajectdomein/nieuwtraject";
    }

    @RequestMapping(value = {"nieuwtraject"}, method = RequestMethod.POST)
    public String saveTraject(@Valid Traject traject, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "Trajectdomein/nieuwtraject";
        }

        trajectService.create(traject);
        int trajectId = traject.getId();
        model.addAttribute("succes", traject.getNaam() + ": "
                + traject.getOmschrijving() + " staat geregistreerd." + "<br><a href=\"http://localhost:8080/Cursisttraject4.0/trajecten/updatetraject-" + trajectId + "\"><b>Nu modules toevoegen aan traject: " + traject.getNaam() + "</b></a>");
        return "Algemeen/bevestigingspagina";
    }

    //Module toevoegen aan een Traject
    @RequestMapping(value = {"/{trajectId}/nieuwemoduleintraject"}, method = RequestMethod.GET)
    public String nieuweModuleGet(@PathVariable int trajectId, Module module, ModelMap model) {

        //   module = new Module();
        module.setTraject(trajectService.read(trajectId));
        model.addAttribute("module", module);

        return "Trajectdomein/nieuwemoduleintraject";
    }

    @RequestMapping(value = {"/{trajectId}/nieuwemoduleintraject"}, method = RequestMethod.POST)
    public String nieuweModulePost(@PathVariable int trajectId, @Valid Module module, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "Trajectdomein/nieuwemoduleintraject";
        }
        Traject trajectRead = trajectService.read(trajectId);
        trajectRead.getModules().add(module);
        module.setTraject(trajectRead);
      // moduleService.create(module);

        trajectService.update(trajectRead);

        model.addAttribute("succes", module.getOmschrijving() + ": " + "in " + module.getTraject().getNaam() + " staat geregistreerd.");
        return "Algemeen/bevestigingspagina";

    }

    // Toetsresulaat verwijderen
    @RequestMapping(value = {"/delete-module-in-traject-{moduleId}"}, method = RequestMethod.GET)
    public String verwijderModuleGet(@PathVariable int moduleId, @ModelAttribute("module") Module module, BindingResult result, ModelMap model) {
        
        module = moduleService.read(moduleId);
        Traject traject = module.getTraject();
        model.addAttribute("traject", traject);
        model.addAttribute("module", module);        

        return "Trajectdomein/verwijdermoduleintraject";
    }

    @RequestMapping(value = {"/delete-module-in-traject-{moduleId}"}, method = RequestMethod.POST)
    public String deleteModulePost(@PathVariable int moduleId, @ModelAttribute("module") Module module, BindingResult result, ModelMap model) {
        Module moduleRead = moduleService.read(moduleId);
        Traject traject = moduleRead.getTraject();
        moduleRead = module;
        moduleRead.setId(moduleId);
        traject.getModules().remove(moduleRead);
        trajectService.update(traject);
        
        moduleService.delete(moduleRead);
         model.addAttribute("succes", "De module " + " is verwijderd");
        return "Algemeen/bevestigingspagina";
    }
//    @RequestMapping(value = {"/delete-module-in-traject-{moduleId}"}, method = RequestMethod.POST)
//    public String verwijderModulePost(@PathVariable int moduleId, ModelMap model) {
//
//        Module module = moduleService.read(moduleId);
//        Traject traject = module.getTraject();
//        traject.getModules().remove(module);
//        module.setTraject(new Traject());
//        
//        trajectService.update(traject);
//        moduleService.update(module);
//        
//        model.addAttribute("succes", "De module " +  module.getOmschrijving()+ " in traject " + traject.getNaam() + " is verwijderd");
//
//        return "Algemeen/bevestigingspagina";
//    }
}
