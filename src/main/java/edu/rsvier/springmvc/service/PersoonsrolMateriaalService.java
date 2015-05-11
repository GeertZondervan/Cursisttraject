package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.PersoonsrolHasMateriaal;
import edu.rsvier.springmvc.model.PersoonsrolHasMateriaalId;
import java.util.List;


public interface PersoonsrolMateriaalService {
    void create(PersoonsrolHasMateriaal hasMat) throws IllegalArgumentException;

    void update(PersoonsrolHasMateriaal hasMat);

    PersoonsrolHasMateriaal read(PersoonsrolHasMateriaalId id) throws NullPointerException;

    void delete(PersoonsrolHasMateriaal hasMat);

    List<PersoonsrolHasMateriaal> getAll();

    void flushSession();
}
