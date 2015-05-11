package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.PersoonsrolHasMateriaal;
import edu.rsvier.springmvc.model.PersoonsrolHasMateriaalId;
import java.util.List;

public interface PersoonsrolHasMateriaalDao {

    void create(PersoonsrolHasMateriaal hasMat);

    void update(PersoonsrolHasMateriaal hasMat);

    PersoonsrolHasMateriaal read(PersoonsrolHasMateriaalId id);

    void delete(PersoonsrolHasMateriaal hasMat);

    List<PersoonsrolHasMateriaal> getAll();

    void flushSession();
}
