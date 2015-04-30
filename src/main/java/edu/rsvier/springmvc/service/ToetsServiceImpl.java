
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
    
    public void create(Toets toets) {
        dao.create(toets);
    }

    public void update(Toets toets) {
        dao.update(toets);
    }

    public Toets read(int id) {
        return ((Toets)dao.read(id));
    }

    public void delete(Toets toets) {
       dao.delete(toets);
    }

    public List<Toets> getAll() {
      return dao.getAll();
    }
    
}
