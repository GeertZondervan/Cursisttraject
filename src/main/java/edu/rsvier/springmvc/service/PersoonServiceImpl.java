package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.dao.PersoonDao;
import edu.rsvier.springmvc.model.Persoon;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("persoonService")
@Transactional
public class PersoonServiceImpl implements PersoonService {

    @Autowired
    private PersoonDao dao;

    public void create(Persoon persoon) {
        dao.create(persoon);
    }

    public Persoon read(int id) {
        return ((Persoon) dao.read(id));
    }

    public void update(Persoon persoon) {
        dao.update(persoon);
    }

    public void delete(Persoon persoon) {
        dao.delete(persoon);
    }

    public List<Persoon> getAll() {
        return dao.getAll();
    }

    public List<Persoon> read(String voornaam, String achternaam) {
        return dao.read(voornaam, achternaam);
    }

}
