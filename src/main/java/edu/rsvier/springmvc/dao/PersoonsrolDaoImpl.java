package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.PersoonsrolId;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("persoonsrolDao")
public class PersoonsrolDaoImpl extends GenericDaoImpl<Persoonsrol> implements PersoonsrolDao {

    public PersoonsrolDaoImpl() {
        super(Persoonsrol.class);
    }

    public Persoonsrol read(PersoonsrolId id) {
        String sql = "SELECT p FROM Persoonsrol p WHERE persoon_id = :persoon_id AND rol_id = :rol_id AND begindatum = :begindatum";
        Query query = getSession().createQuery(sql).setParameter("persoon_id", id.getPersoonId()).setParameter("rol_id", id.getRolId())
                                .setParameter("begindatum", java.sql.Date.valueOf(id.getBegindatum()));
        
        if (query.list().isEmpty()) {
            return null;
        }
        return (Persoonsrol) query.list().get(0);
    }

    public Persoonsrol read(int persoonId, int rolId) {
        String sql = "SELECT p FROM Persoonsrol p WHERE persoon_id = :persoon_id AND rol_id = :rol_id";
        Query query = getSession().createQuery(sql).setParameter("persoon_id", persoonId).setParameter("rol_id", rolId);
        
        if (query.list().isEmpty()) {
            return null;
        }
        return (Persoonsrol) query.list().get(0);
    }
}
