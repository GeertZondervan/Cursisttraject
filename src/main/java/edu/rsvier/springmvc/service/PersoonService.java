
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.Persoon;
import java.util.List;
 
public interface PersoonService {
 
    void createPersoon(Persoon persoon);
    
    void updatePersoon(Persoon persoon);
     
    List<Persoon> findAllPersonen(); 
    
    Persoon getPersoon(String voornaam, String achternaam);
    
    Integer getPersoonId(String voornaam, String achternaam);
     
    void deletePersoon(String voornaam, String achternaam);
    
    Persoon read(int id);
}