
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.ToetsResultaat;
import edu.rsvier.springmvc.model.ToetsResultaatId;
import java.util.List;

public interface ToetsResultaatService {
    void create(ToetsResultaat toetsResultaat) throws IllegalArgumentException;

    void update(ToetsResultaat toetsResultaat);

    ToetsResultaat read(ToetsResultaatId id)  throws NullPointerException;

    void delete(ToetsResultaat toetsResultaat);

    List<ToetsResultaat> getAll();
    
    void flushSession();
}
