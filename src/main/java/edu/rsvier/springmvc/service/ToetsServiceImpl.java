
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.dao.ToetsDao;
import edu.rsvier.springmvc.model.Toets;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("toetsService")
@Transactional
public class ToetsServiceImpl implements ToetsService{

    @Autowired
    private ToetsDao dao;
    
    public void create(Toets toets) throws IllegalArgumentException  {
       if (toets.getNaam() == null) {
            throw new IllegalArgumentException("Toets not complete");
        }
        dao.create(toets);
    }
    
    
    public Toets read(int id)  throws NullPointerException {
       Toets toets = dao.read(id);
        if (toets ==  null) {
            throw new NullPointerException("Toets not found");
        }
        return toets;
    }

    public void update(Toets toets) {
        dao.update(toets);
    }

    public void delete(Toets toets) {
       dao.delete(toets);
    }

    public List<Toets> getAll() {
      return dao.getAll();
    }
    public void flushSession() {
        dao.flushSession();
    }    
}
