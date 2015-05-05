
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.Persoon;
import java.util.List;
 
public interface PersoonService {
 
    void create(Persoon persoon);
    
    void update(Persoon persoon);
     
    List<Persoon> getAll(); 
   
    List<Persoon> read(String voornaam, String achternaam);

    void delete(Persoon persoon);
   
    Persoon read(int id);
    
    public void flushSession();
}