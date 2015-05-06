package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.Bestand;
import java.util.List;

public interface BestandService {

    void create(Bestand bestand);

    void update(Bestand bestand);

    List<Bestand> getAll();

    void delete(Bestand bestand);

    Bestand read(int id);
    
    void flushSession();
}
