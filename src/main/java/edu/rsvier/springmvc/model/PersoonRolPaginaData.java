/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rsvier.springmvc.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wiemer
 */
public class PersoonRolPaginaData {
    
    private Persoon persoon = new Persoon();
    
    private List<String> persoonsrolNamen = new ArrayList<String>();

    public List<String> getPersoonsrolnamen() {
        return persoonsrolNamen;
    }

    public void setPersoonsrolnamen(List<String> persoonsrolNamen) {
        
        this.persoonsrolNamen = persoonsrolNamen;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    
    
    
}
