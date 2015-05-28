package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.dao.ExpertiseDao;
import edu.rsvier.springmvc.model.Expertise;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("expertiseService")
@Transactional
public class ExpertiseServiceImpl implements ExpertiseService {

    @Autowired
    private ExpertiseDao dao;

    public void create(Expertise expertise) throws IllegalArgumentException {
        if (expertise.getNaam() == null) {
            throw new IllegalArgumentException("Expertise not complete");
        }
        
        
        dao.create(expertise);
    }

    public Expertise read(int id) throws NullPointerException {
        Expertise expertise = dao.read(id);
        if (expertise == null) {
            throw new NullPointerException("Expertise not found");
        }

        return expertise;
    }

    public void update(Expertise expertise) {
        dao.update(expertise);
    }

    public void delete(Expertise expertise) {
        dao.delete(expertise);
    }

    public List<Expertise> getAll() {
        return dao.getAll();
    }

    public List<Expertise> read(String naam) {
        return dao.read(naam);
    }

    public void flushSession() {
        dao.flushSession();
    }

}
