package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.PersoonsrolId;

public interface PersoonsrolService {

    void create(Persoonsrol persoonsrol) throws IllegalArgumentException;

    void update(Persoonsrol persoonsrol);

    Persoonsrol read(PersoonsrolId id) throws NullPointerException;

    void delete(Persoonsrol persoonsrol);

    void flushSession();
    
    Persoonsrol read(int persoonId, int rolId) throws NullPointerException;
}
