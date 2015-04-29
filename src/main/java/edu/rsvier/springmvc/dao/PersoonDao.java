package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Persoon;
import java.util.List;

public interface PersoonDao {

    void create(Persoon persoon);

    void update(Persoon persoon);

    Persoon read(int id);
    /*
     int getPersoonId(String voornaam, String achternaam);
    
     Persoon getPersoon(String voornaam, String achternaam);
     */

    void delete(Persoon persoon);

    List<Persoon> getAll();
}
