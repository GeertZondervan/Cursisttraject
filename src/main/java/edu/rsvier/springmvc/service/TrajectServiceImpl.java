
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.dao.TrajectDao;
import edu.rsvier.springmvc.model.Traject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("trajectService")
@Transactional
public class TrajectServiceImpl implements TrajectService {
    
    @Autowired 
    private TrajectDao dao;

    public void create(Traject traject) {
        dao.create(traject);
    }

    public void update(Traject traject) {
        dao.update(traject);
    }

    public Traject read(int id) {
       return ((Traject) dao.read(id));
    }

    public List<Traject> read(String naam) {
       return dao.read(naam);
    }

    public void delete(Traject traject) {
       dao.delete(traject);
    }

    public List<Traject> getAll() {
        return dao.getAll();
    }
    
}
