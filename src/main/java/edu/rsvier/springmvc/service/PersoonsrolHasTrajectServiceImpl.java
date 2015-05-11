
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.dao.PersoonsrolHasTrajectDao;
import edu.rsvier.springmvc.model.PersoonsrolHasTraject;
import edu.rsvier.springmvc.model.PersoonsrolHasTrajectId;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("persoonsrolHasTrajectService")
@Transactional
public class PersoonsrolHasTrajectServiceImpl implements PersoonsrolHasTrajectService {
    
    @Autowired
    private PersoonsrolHasTrajectDao dao;

    public void create(PersoonsrolHasTraject hasTraject) throws IllegalArgumentException {
        if(hasTraject.getBegindatum() == null || hasTraject.getPersoonsrol() == null || hasTraject.getTraject() == null){
            throw new IllegalArgumentException("PersoonsrolHasTraject not complete");
        }
        dao.create(hasTraject);
    }

    public void update(PersoonsrolHasTraject hasTraject) {
       dao.update(hasTraject);
    }

    public PersoonsrolHasTraject read(PersoonsrolHasTrajectId id) throws NullPointerException {
       PersoonsrolHasTraject persoonTraject = dao.read(id);
        if (persoonTraject == null) {
            throw new NullPointerException("PersoonsrolHasTraject not found");
        }

        return persoonTraject;
    }

    public void delete(PersoonsrolHasTraject hasTraject) {
        dao.delete(hasTraject);
    }

    public List<PersoonsrolHasTraject> getAll() {
         return dao.getAll();
    }

    public void flushSession() {
        dao.flushSession();
    }
    
}
