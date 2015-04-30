
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.PersoonsrolId;

public interface PersoonsrolService {
    
    void create(Persoonsrol persoonsrol);

    void update(Persoonsrol persoonsrol);

    Persoonsrol read(PersoonsrolId id);

    void delete(Persoonsrol persoonsrol);

}
