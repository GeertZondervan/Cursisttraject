package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Expertise;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("expertiseDao")
public class ExpertiseDaoImpl extends GenericDaoImpl<Expertise> implements ExpertiseDao {

    public ExpertiseDaoImpl() {
        super(Expertise.class);
    }

    public Expertise getExpertise(String naam) {
        String sql = "SELECT e FROM Expertise e WHERE e.naam = :naam";
        Query query = getSession().createQuery(sql).setParameter("naam", naam);
        if (query.list().isEmpty()) {
            return null;
        }
        return ((Expertise) query.list().get(query.list().size() - 1));
    }

}
