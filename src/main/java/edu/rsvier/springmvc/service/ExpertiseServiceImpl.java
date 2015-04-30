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

    public void create(Expertise expertise) {
        dao.create(expertise);
    }

    public Expertise read(int id) {
        return ((Expertise) dao.read(id));
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


}
