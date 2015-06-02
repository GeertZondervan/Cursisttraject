package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.dao.PersoonsrolDao;
import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.PersoonsrolId;
import java.util.ArrayList;
import java.util.List;
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
        if (persoonsrol == null) {
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

    public void flushSession() {
        dao.flushSession();
    }

    public Persoonsrol read(int persoonId, int rolId) throws NullPointerException {
        Persoonsrol persoonsrol = dao.read(persoonId, rolId);
        System.out.println(persoonsrol);
        return persoonsrol;
    }

    public List<Persoonsrol> getAll() {
        return dao.getAll();
    }

    public List<Persoonsrol> getAllWithRol(String rolNaam) {
        List<Persoonsrol> persoonsrolWithRol = new ArrayList<Persoonsrol>();

        for (Persoonsrol persoonsrol : getAll()) {
            if (persoonsrol.getRol().getNaam().contains("Student")) {
                persoonsrolWithRol.add(persoonsrol);
                {
                }

            }
            
        }
        return persoonsrolWithRol;
    }
}
