
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.PersoonsrolHasTraject;
import edu.rsvier.springmvc.model.PersoonsrolHasTrajectId;
import java.util.List;


public interface PersoonsrolHasTrajectService {

    void create(PersoonsrolHasTraject hasTraject) throws IllegalArgumentException;;

    void update(PersoonsrolHasTraject hasTraject);

    PersoonsrolHasTraject read(PersoonsrolHasTrajectId id)  throws NullPointerException;

    void delete(PersoonsrolHasTraject hasTraject);

    List<PersoonsrolHasTraject> getAll();

    void flushSession();
}
