package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.*;
import java.sql.Date;
import java.time.LocalDate;

import java.util.HashSet;


/**
 *
 * @author Wiemer, Shun, Geert
 */
public class PojoGenerator {
    static LocalDate date = LocalDate.now();
    
    static int i;

    static Bestand getBestand() {
        i += 1;
        Bestand bestand = new Bestand();
        bestand.setBestand(new byte[i]);

        return bestand;
    }

    static Expertise getExpertise(Module module) {
        i += 1;
        Expertise expertise = new Expertise();
        expertise.setModule(module);
        expertise.setNaam("Bierbommen bouwen" + i);
        expertise.setOmschrijving("The art of making and baking beerbombs" + i);
        return expertise;
    }

    static Materiaal getMateriaal() {
        i += 1;
        Materiaal materiaal = new Materiaal();
        materiaal.setTitel("Javaboek " + i);
        materiaal.setAuteur("Jenkov jonguh");
        
        materiaal.setOmschrijving("Jenkov is een demigod!");
        
        return materiaal;
    }

    static Module getModule(Traject traject) {
        i += 1;
        Module module = new Module();
        module.setOmschrijving("Module " + i);
        module.setTraject(traject);
        return module;
    }

    static Persoon getPersoon() {
        i += 1;
        Persoon persoon = new Persoon();
        
        persoon.setVoornaam("Henk " + i);
        persoon.setAchternaam("De Tank" + i);
        persoon.setPersoonsrollen(new HashSet<Persoonsrol>());
        persoon.setExpertises(new HashSet<Expertise>());
        return persoon;
    }

    static Persoonsrol getPersoonsrol(Persoon persoon, Rol rol) {
        i += 1;
        PersoonsrolId persoonsrolId = new PersoonsrolId();
        persoonsrolId.setPersoonId(persoon.getId());
        persoonsrolId.setRolId(rol.getId());

        
        persoonsrolId.setBegindatum(date);

        Persoonsrol persoonsrol = new Persoonsrol();
        persoonsrol.setPersoon(persoon);
        persoonsrol.setRol(rol);
        persoonsrol.setId(persoonsrolId);

        return persoonsrol;
    }
    
     static PersoonsrolHasMateriaal getPersoonsrolHasMateriaal(Materiaal materiaal, Persoonsrol persoonsrol) {
        i+=1;
        PersoonsrolHasMateriaal hasMat = new PersoonsrolHasMateriaal();
        hasMat.setPersoonsrol(persoonsrol);
        hasMat.setMateriaal(materiaal);
        hasMat.setCursistBezit('Y');
        hasMat.setId(getPersoonsrolHasMateriaalId(persoonsrol.getId(), materiaal));
        
        return hasMat;
    }
    
    static PersoonsrolHasMateriaalId getPersoonsrolHasMateriaalId(PersoonsrolId persoonsrolId, Materiaal materiaal) {
        i+=1;
        PersoonsrolHasMateriaalId id = new PersoonsrolHasMateriaalId();
        id.setPersoonsrolPersoonId(persoonsrolId.getPersoonId());
        id.setPersoonsrolRolId(persoonsrolId.getRolId());
        id.setPersoonsrolBegindatum(date);
        id.setMateriaalId(materiaal.getId());
        
        return id;
    }
    
    static PersoonsrolHasTraject getPersoonsrolHasTraject(Traject traject, Persoonsrol persoonsrol){
        i+=1;
        PersoonsrolHasTraject hasTraject = new PersoonsrolHasTraject();
        hasTraject.setPersoonsrol(persoonsrol);
        hasTraject.setTraject(traject);
        hasTraject.setBegindatum(date);
        hasTraject.setSuccesvolAfgerond('Y');
        hasTraject.setId(getPersoonsrolHasTrajectId(persoonsrol.getId(), traject));
        
        return hasTraject;
    
    }
    
    static PersoonsrolHasTrajectId getPersoonsrolHasTrajectId(PersoonsrolId persoonsrolId, Traject traject){
        i+=1;
        PersoonsrolHasTrajectId id = new PersoonsrolHasTrajectId();
        id.setPersoonsrolPersoonId(persoonsrolId.getPersoonId());
        id.setPersoonsrolRolId(persoonsrolId.getRolId());
        id.setPersoonsrolBegindatum(persoonsrolId.getBegindatum());
        id.setTrajectId(traject.getId());
        
        return id;
    }

    static Rol getRol() {
        i += 1;
        Rol rol = new Rol();
        rol.setNaam("Cursist" + i);
        return rol;
    }

    static Toets getToets(Module module) {
        i += 1;
        Toets toets = new Toets();
        toets.setNaam("Java toets " + i);
        toets.setOmschrijving("Eerste toets " + i);
        toets.setStof("Boek " + i);
        toets.setStatus("Klaar" + i);
        toets.setMinimumResultaat(5.5f);
        toets.setModule(module);

        return toets;
    }
    
    static ToetsResultaat getToetsResultaat(Toets toets, Persoonsrol persoonsrol){
        i+=1;
        ToetsResultaat toetsResultaat = new ToetsResultaat();
        toetsResultaat.setToets(toets);
        toetsResultaat.setPersoonsrol(persoonsrol);
        toetsResultaat.setId(getToetsResultaatId(persoonsrol.getId(), toets));
        toetsResultaat.setResultaat(5.5f);
        toetsResultaat.setDatum(date);
        
        return toetsResultaat;
    }
    
        static ToetsResultaatId getToetsResultaatId(PersoonsrolId persoonsrolId, Toets toets){
        i+=1;
        ToetsResultaatId toetsResultaatId = new ToetsResultaatId();
        toetsResultaatId.setToetsId(toets.getId());
        toetsResultaatId.setPersoonsrolBegindatum(date);
        toetsResultaatId.setPersoonsrolPersoonId(persoonsrolId.getPersoonId());
        toetsResultaatId.setPersoonsrolRolId(persoonsrolId.getRolId());
        
        return toetsResultaatId;
    }
 
    static Traject getTraject() {
        i += 1;
        Traject traject = new Traject();
        traject.setNaam("Basistraject");
        traject.setOmschrijving("Opleiding tot Java Developer" + i);
        traject.setStartdatum(date);
        return traject;
    }
}
