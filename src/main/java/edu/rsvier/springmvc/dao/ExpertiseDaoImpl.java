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

    public List<Expertise> read(String naam) {
        String sql = "SELECT e FROM Expertise e WHERE e.naam = :naam";
        Query query = getSession().createQuery(sql).setParameter("naam", naam);
        if (query.list().isEmpty()) {
            return null;
        }
        return(List<Expertise>)query.list();
    }

}
