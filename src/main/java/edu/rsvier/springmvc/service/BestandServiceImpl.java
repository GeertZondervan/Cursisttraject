package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.dao.BestandDao;
import edu.rsvier.springmvc.dao.ExpertiseDao;
import edu.rsvier.springmvc.model.Bestand;
import edu.rsvier.springmvc.model.Expertise;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bestandService")
@Transactional
public class BestandServiceImpl implements BestandService {

    @Autowired
    private BestandDao dao;

    public void create(Bestand bestand) {
        dao.create(bestand);
    }

    public Bestand read(int id) {
        return ((Bestand) dao.read(id));
    }

    public void update(Bestand bestand) {
        dao.update(bestand);
    }

    public void delete(Bestand bestand) {
        dao.delete(bestand);
    }

    public List<Bestand> getAll() {
        return dao.getAll();
    }

}
