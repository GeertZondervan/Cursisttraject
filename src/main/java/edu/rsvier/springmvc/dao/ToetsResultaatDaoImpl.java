
package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Toets;
import edu.rsvier.springmvc.model.ToetsResultaat;
import edu.rsvier.springmvc.model.ToetsResultaatId;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("toetsResultaatDao")

public class ToetsResultaatDaoImpl extends GenericDaoImpl<ToetsResultaat> implements ToetsResultaatDao {

    public ToetsResultaatDaoImpl() {
        super(ToetsResultaat.class);
    }

    public ToetsResultaat read(ToetsResultaatId id) {
        String sql = "SELECT p FROM ToetsResultaat p WHERE persoonsrol_persoon_id = :persoon_id"
                + " AND persoonsrol_rol_id = :rol_id AND persoonsrol_begindatum = :begindatum"
                + " AND toets_id = :toets_id";
        Query query = getSession().createQuery(sql).setParameter("persoon_id", id.getPersoonsrolPersoonId()).setParameter("rol_id", id.getPersoonsrolRolId())
                .setParameter("begindatum", java.sql.Date.valueOf(id.getPersoonsrolBegindatum())).setParameter("toets_id", id.getToetsId());
        if (query.list().isEmpty()) {
            return null;
        }
        return (ToetsResultaat) query.list().get(0);
    }
//    public ToetsResultaat read(ToetsResultaatId id) {
//        String sql = "SELECT p FROM ToetsResultaat p WHERE p.persoonsrol_persoon_id = :persoon_id"
//                + " AND p.persoonsrol_rol_id = :rol_id AND p.persoonsrol_begindatum = :begindatum"
//                + " AND p.toets_id = :toets_id";
//        Query query = getSession().createQuery(sql).setParameter("persoon_id", id.getPersoonsrolPersoonId()).setParameter("rol_id", id.getPersoonsrolRolId())
//                .setParameter("begindatum", id.getPersoonsrolBegindatum()).setParameter("toets_id", id.getToetsId());
//        if (query.list().isEmpty()) {
//            return null;
//        }
//        return (ToetsResultaat) query.list().get(0);
//    }

    
    public List<ToetsResultaat> getForToets(Toets toets) {
        String sql = "SELECT r FROM ToetsResultaat r WHERE toets_id = :toets_id";
        Query query = getSession().createQuery(sql).setParameter("toets_id", toets.getId());
        if (query.list().isEmpty()) {
            return null;
        }
        return query.list();
    }
    
}
