package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Bestand;
import java.util.List;

public interface BestandDao {

    void create(Bestand bestand);

    void update(Bestand bestand);

    Bestand read(int id);

    void delete(Bestand bestand);

    List<Bestand> getAll();
    
}
