package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.PersoonsrolHasMateriaal;
import edu.rsvier.springmvc.model.PersoonsrolHasMateriaalId;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("persoonsrolHasMateriaalDao")
public class PersoonsrolHasMateriaalDaoImpl extends GenericDaoImpl<PersoonsrolHasMateriaal> implements PersoonsrolHasMateriaalDao {

    public PersoonsrolHasMateriaalDaoImpl() {
        super(PersoonsrolHasMateriaal.class);
    }

    public PersoonsrolHasMateriaal read(PersoonsrolHasMateriaalId id) {
        String sql = "SELECT p FROM PersoonsrolHasMateriaal p WHERE persoonsrol_persoon_id = :persoon_id"
                + " AND persoonsrol_rol_id = :rol_id AND persoonsrol_begindatum = :begindatum"
                + " AND materiaal_id = :materiaal_id";
        Query query = getSession().createQuery(sql).setParameter("persoon_id", id.getPersoonsrolPersoonId()).setParameter("rol_id", id.getPersoonsrolRolId())
                .setParameter("begindatum", id.getPersoonsrolBegindatum()).setParameter("materiaal_id", id.getMateriaalId());
        if (query.list().isEmpty()) {
            return null;
        }
        return (PersoonsrolHasMateriaal) query.list().get(0);
    }
}
