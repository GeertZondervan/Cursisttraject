package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.dao.ToetsResultaatDao;
import edu.rsvier.springmvc.model.ToetsResultaat;
import edu.rsvier.springmvc.model.ToetsResultaatId;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("toetsResultaatService")
@Transactional
public class ToetsResultaatServiceImpl implements ToetsResultaatService {

    @Autowired
    private ToetsResultaatDao dao;

    public void create(ToetsResultaat toetsResultaat) throws IllegalArgumentException {
        if (toetsResultaat.getToets() == null || toetsResultaat.getPersoonsrol() == null) {
            throw new IllegalArgumentException("ToetsResultaat not complete");
        }
        dao.create(toetsResultaat);
    }

    public ToetsResultaat read(ToetsResultaatId id) throws NullPointerException {
        ToetsResultaat toetsResultaat = dao.read(id);
        if (toetsResultaat == null) {
            throw new NullPointerException("ToetsResultaat not found");
        }

        return toetsResultaat;
    }

    public void update(ToetsResultaat toetsResultaat) {
        dao.update(toetsResultaat);
    }

    public void delete(ToetsResultaat toetsResultaat) {
        dao.delete(toetsResultaat);
    }

    public List<ToetsResultaat> getAll() {
        return dao.getAll();
    }

    public void flushSession() {
        dao.flushSession();
    }

}
