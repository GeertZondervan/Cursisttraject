
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.dao.PersoonsrolDao;
import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.PersoonsrolId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("persoonsrolService")
@Transactional
public class PersoonsrolServiceImpl implements PersoonsrolService {
    @Autowired
    private PersoonsrolDao dao;

    public void create(Persoonsrol persoonsrol) throws IllegalArgumentException {
        if (persoonsrol.getPersoon() == null || persoonsrol.getRol() == null) {
            throw new IllegalArgumentException("Persoonsrol not complete");
        }
        dao.create(persoonsrol);
    }

    public Persoonsrol read(PersoonsrolId id) throws NullPointerException {
        Persoonsrol persoonsrol = dao.read(id);
        if (persoonsrol == null ) {
            throw new NullPointerException("Persoonsrol not found");
        }

        return persoonsrol;
    }

    public void update(Persoonsrol persoonsrol) {
       dao.update(persoonsrol);
    }

   

    public void delete(Persoonsrol persoonsrol) {
        dao.delete(persoonsrol);
    }

    
}
