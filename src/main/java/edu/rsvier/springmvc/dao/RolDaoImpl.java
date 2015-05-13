package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Rol;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
@Repository("rolDao")
public class RolDaoImpl extends GenericDaoImpl<Rol> implements RolDao {

    public RolDaoImpl() {
        super(Rol.class);
    }
    
    public List<Rol> read(String naam){
        String sql = "SELECT r FROM Rol r WHERE r.naam = :naam";
        Query query = getSession().createQuery(sql).setParameter("naam", naam);
        if (query.list().isEmpty()) {
            return null;
        }
        return query.list();
    }
    
}
