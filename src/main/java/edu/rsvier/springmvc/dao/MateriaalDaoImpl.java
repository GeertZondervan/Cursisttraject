package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Materiaal;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("materiaalDao")
public class MateriaalDaoImpl extends GenericDaoImpl<Materiaal> implements MateriaalDao {

    public MateriaalDaoImpl() {
        super(Materiaal.class);
    }

    public List<Materiaal> read(String titel) {
        String sql = "SELECT m FROM Materiaal m WHERE m.titel = :titel";
        Query query = getSession().createQuery(sql).setParameter("titel", titel);
        if (query.list().isEmpty()) {
            return null;
        }
        return(List<Materiaal>)query.list();
    }

}