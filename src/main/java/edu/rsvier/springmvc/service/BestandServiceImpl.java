package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.dao.BestandDao;
import edu.rsvier.springmvc.model.Bestand;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bestandService")
@Transactional
public class BestandServiceImpl implements BestandService {

    @Autowired
    private BestandDao dao;

    public void create(Bestand bestand) throws IllegalArgumentException {
        if (bestand.getBestand() == null) {
            throw new IllegalArgumentException("Bestand not complete");
        }
        dao.create(bestand);
    }

    public Bestand read(int id) throws NullPointerException {
        Bestand bestand = dao.read(id);
        if (bestand == null) {
            throw new NullPointerException("Bestand not found");
        }

        return bestand;
    }

    public void update(Bestand bestand) throws IllegalArgumentException {
        dao.update(bestand);
    }

    public void delete(Bestand bestand) {
        dao.delete(bestand);
    }

    public List<Bestand> getAll() {
        return dao.getAll();
    }

    public void flushSession() {
        dao.flushSession();
    }

}
