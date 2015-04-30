
package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Traject;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("trajectDao")

public class TrajectDaoImpl extends GenericDaoImpl<Traject> implements TrajectDao{
    public TrajectDaoImpl(){
        super(Traject.class);
    }

    public List<Traject> read(String naam) {
        String sql = "SELECT p FROM Traject p WHERE p.naam = :naam";
        Query query = getSession().createQuery(sql).setParameter("naam", naam);
        if (query.list().isEmpty()) {
            return null;
        }
        return query.list();
    }
    
}
