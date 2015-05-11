package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.PersoonsrolHasTraject;
import edu.rsvier.springmvc.model.PersoonsrolHasTrajectId;
import java.util.List;

public interface PersoonsrolHasTrajectDao {

    void create(PersoonsrolHasTraject hasTraject);

    void update(PersoonsrolHasTraject hasTraject);

    PersoonsrolHasTraject read(PersoonsrolHasTrajectId id);

    void delete(PersoonsrolHasTraject hasTraject);

    List<PersoonsrolHasTraject> getAll();

    void flushSession();
}
