package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Persoon;
import java.util.List;

public interface PersoonDao {

    void create(Persoon persoon);

    void update(Persoon persoon);

    Persoon read(int id);

    List<Persoon> read(String voornaam, String achternaam);

    void delete(Persoon persoon);

    List<Persoon> getAll();
    void flushSession();
}
