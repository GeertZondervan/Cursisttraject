
package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Toets;
import edu.rsvier.springmvc.model.ToetsResultaat;
import edu.rsvier.springmvc.model.ToetsResultaatId;
import java.util.List;


public interface ToetsResultaatDao {

    void create(ToetsResultaat toetsResultaat);

    void update(ToetsResultaat toetsResultaat);

    ToetsResultaat read(ToetsResultaatId id);

    void delete(ToetsResultaat toetsResultaat);

    List<ToetsResultaat> getAll();
    
    void flushSession();

    public List<ToetsResultaat> getForToets(Toets toets);
}
