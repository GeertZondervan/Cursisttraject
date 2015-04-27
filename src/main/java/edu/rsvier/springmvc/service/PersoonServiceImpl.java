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

    public void createPersoon(Persoon persoon) {
        dao.create(persoon);
    }

    public List<Persoon> findAllPersonen() {
       return dao.getAll();
    }

    public void deletePersoon(String voornaam, String achternaam) {
        dao.delete(dao.getPersoon(voornaam, achternaam));
    }

    public void updatePersoon(Persoon persoon) {     
        dao.update(persoon);
    }

    public Persoon getPersoon(String voornaam, String achternaam) {
        return(((Persoon)dao.getPersoon(voornaam, achternaam)));    
    }

    public Persoon read(int id) {
        return(dao.read(id));
    }

    public Integer getPersoonId(String voornaam, String achternaam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }
