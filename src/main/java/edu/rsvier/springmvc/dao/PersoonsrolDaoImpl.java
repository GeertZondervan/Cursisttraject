package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.PersoonsrolId;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("persoonsrolDao")
public class PersoonsrolDaoImpl extends GenericDaoImpl<Persoonsrol> implements PersoonsrolDao {

    public PersoonsrolDaoImpl() {
        super(Persoonsrol.class);
    }

    public Persoonsrol read(PersoonsrolId id) {
        String sql = "SELECT p FROM Persoonsrol p WHERE p.persoon_id = :persoon_id AND p.rol_id = :rol_id AND p.begindatum = :begindatum";
        Query query = getSession().createQuery(sql).setParameter("persoon_id", id.getPersoonId()).setParameter("rol_id", id.getRolId())
                .setParameter("begindatum", id.getBegindatum());
        if (query.list().isEmpty()) {
            return null;
        }
        return (Persoonsrol) query.list().get(0);
    }
}
