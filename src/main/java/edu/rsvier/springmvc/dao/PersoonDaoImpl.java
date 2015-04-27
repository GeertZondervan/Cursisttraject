package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Persoon;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("persoonDao")
public class PersoonDaoImpl extends AbstractDao implements PersoonDao {

    public void create(Persoon persoon) {
        super.create(persoon);
    }

    public void update(Persoon persoon) {
        super.update(persoon);
    }

    public Persoon read(int id) {
        return ((Persoon) super.get(Persoon.class, id));
    }

    public int getPersoonId(String voornaam, String achternaam) {
        String sql = "SELECT p FROM Persoon p WHERE p.voornaam = :voornaam AND p.achternaam = :achternaam";
        Query query = getSession().createQuery(sql).setParameter("voornaam", voornaam).setParameter("achternaam", achternaam);
        List<Persoon> list = query.list();
        if (query.list().isEmpty()) {
            return -1;
        }
        return list.get(list.size() - 1).getId();
    }

    public Persoon getPersoon(String voornaam, String achternaam) {
        String sql = "SELECT p FROM Persoon p WHERE p.voornaam = :voornaam AND p.achternaam = :achternaam";
        Query query = getSession().createQuery(sql).setParameter("voornaam", voornaam).setParameter("achternaam", achternaam);
        if (query.list().isEmpty()) {
            return null;
        }
        return ((Persoon) query.list().get(query.list().size() - 1));
    }

    public void delete(Persoon persoon) {
        super.delete(persoon);
    }

    public List<Persoon> getAll() {
        Query query = getSession().createQuery("From Persoon");
        List<Persoon> list = query.list();
        return list;
    }

}
