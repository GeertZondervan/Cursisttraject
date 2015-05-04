/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.Persoon;
import edu.rsvier.springmvc.model.Persoonsrol;
import java.util.HashSet;

/**
 *
 * @author Wiemer
 */
public class PojoGenerator {
    static int i;
    
    static Persoon getPersoon(){
        i+=1;
        Persoon persoon = new Persoon();
        persoon.setVoornaam("Henk " + i);
        persoon.setAchternaam("De Tank");
        persoon.setPersoonsrollen(new HashSet<Persoonsrol>());
        
        return persoon;
    }
}
