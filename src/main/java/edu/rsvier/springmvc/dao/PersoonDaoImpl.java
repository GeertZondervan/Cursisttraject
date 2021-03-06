package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Persoon;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("persoonDao")
public class PersoonDaoImpl extends GenericDaoImpl<Persoon> implements PersoonDao {

    public PersoonDaoImpl() {
        super(Persoon.class);
    }

    public List<Persoon> read(String voornaam, String achternaam) {
        String sql = "SELECT p FROM Persoon p WHERE p.voornaam = :voornaam AND p.achternaam = :achternaam";
        Query query = getSession().createQuery(sql).setParameter("voornaam", voornaam).setParameter("achternaam", achternaam);
        if (query.list().isEmpty()) {
            return null;
        }
        return query.list();
    }


}
