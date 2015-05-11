package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.PersoonsrolHasTraject;
import edu.rsvier.springmvc.model.PersoonsrolHasTrajectId;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("persoonsrolHasTrajectDao")
public class PersoonsrolHasTrajectDaoImpl extends GenericDaoImpl<PersoonsrolHasTraject> implements PersoonsrolHasTrajectDao{

    public PersoonsrolHasTrajectDaoImpl(){
        super(PersoonsrolHasTraject.class);
    }
    
    public PersoonsrolHasTraject read(PersoonsrolHasTrajectId id) {
        String sql = "SELECT p FROM PersoonsrolHasTraject p WHERE persoonsrol_persoon_id = :persoon_id"
                + " AND persoonsrol_rol_id = :rol_id AND persoonsrol_begindatum = :begindatum"
                + " AND traject_id = :traject_id";
          Query query = getSession().createQuery(sql).setParameter("persoon_id", id.getPersoonsrolPersoonId()).setParameter("rol_id", id.getPersoonsrolRolId())
                .setParameter("begindatum", id.getPersoonsrolBegindatum()).setParameter("traject_id", id.getTrajectId());
        if (query.list().isEmpty()) {
            return null;
        }
        return (PersoonsrolHasTraject) query.list().get(0);
    }
    
}
