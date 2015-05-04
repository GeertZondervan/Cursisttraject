/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;

/**
 *
 * @author Wiemer
 */
public class PojoGenerator {
    static Calendar calendar = new GregorianCalendar(2015, 05, 02);

    static int i;

    static Bestand getBestand() {
        i += 1;
        Bestand bestand = new Bestand();
        bestand.setBestand(new byte[i]);

        return bestand;
    }

    static Expertise getExpertise() {
        i += 1;
        Expertise expertise = new Expertise();
        expertise.setNaam("Bermbommen bouwen" + i);
        expertise.setOmschrijving("The art of making and baking bermbombs" + i);
        return expertise;
    }

    static Materiaal getMateriaal() {
        i += 1;
        Materiaal materiaal = new Materiaal();
        materiaal.setTitel("Javaboek " + i);
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
        return persoon;
    }

    static Persoonsrol getPersoonsrol(Persoon persoon, Rol rol) {
        i += 1;
        PersoonsrolId persoonsrolId = new PersoonsrolId();
        persoonsrolId.setPersoonId(persoon.getId());
        persoonsrolId.setRolId(rol.getId());

        
        persoonsrolId.setBegindatum(calendar.getTime());

        Persoonsrol persoonsrol = new Persoonsrol();
        persoonsrol.setPersoon(persoon);
        persoonsrol.setRol(rol);
        persoonsrol.setId(persoonsrolId);

        return persoonsrol;
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
        toetsResultaat.setId(getToetsResultaatId(persoonsrol.getId(), toets));
        toetsResultaat.setResultaat(5.5f);
        toetsResultaat.setDatum(calendar.getTime());
        
        return toetsResultaat;
    }
    
    static ToetsResultaatId getToetsResultaatId(PersoonsrolId persoonsrolId, Toets toets){
        i+=1;
        ToetsResultaatId toetsResultaatId = new ToetsResultaatId();
        toetsResultaatId.setToetsId(toets.getId());
        toetsResultaatId.setPersoonsrolBegindatum(persoonsrolId.getBegindatum());
        toetsResultaatId.setPersoonsrolPersoonId(persoonsrolId.getPersoonId());
        toetsResultaatId.setPersoonsrolRolId(persoonsrolId.getRolId());
        
        return toetsResultaatId;
    }
   

    static Traject getTraject() {
        i += 1;
        Traject traject = new Traject();
        traject.setNaam("Basistraject" + i);
        traject.setOmschrijving("Opleiding tot Java Developer" + i);
        traject.setStartdatum(new Date());
        return traject;
    }
}
