
package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.ToetsResultaat;
import edu.rsvier.springmvc.model.ToetsResultaatId;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("toetsResultaatDao")

public class ToetsResultaatDaoImpl extends GenericDaoImpl<ToetsResultaat> implements ToetsResultaatDao {

    public ToetsResultaatDaoImpl() {
        super(ToetsResultaat.class);
    }

    public ToetsResultaat read(ToetsResultaatId id) {
        String sql = "SELECT p FROM ToetsResultaat p WHERE p.persoonsrol_persoon_id = :persoons_id "
                + "AND p.persoonsrol_rol_id = :rol_id AND p.persoonrol_begindatum = :begindatum"
                + "AND p.toets_id = :toets_id";
        Query query = getSession().createQuery(sql).setParameter("persoon_id", id.getPersoonsrolPersoonId()).setParameter("rol_id", id.getPersoonsrolRolId())
                .setParameter("begindatum", id.getPersoonsrolBegindatum()).setParameter("toets_id", id.getToetsId());
        if (query.list().isEmpty()) {
            return null;
        }
        return (ToetsResultaat) query.list().get(0);
    }
    
}
