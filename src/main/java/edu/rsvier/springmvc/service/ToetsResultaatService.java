
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.ToetsResultaat;
import edu.rsvier.springmvc.model.ToetsResultaatId;
import java.util.List;

public interface ToetsResultaatService {
      void create(ToetsResultaat toetsResultaat);

    void update(ToetsResultaat toetsResultaat);

    ToetsResultaat read(ToetsResultaatId id);

    void delete(ToetsResultaat toetsResultaat);

    List<ToetsResultaat> getAll();
}
