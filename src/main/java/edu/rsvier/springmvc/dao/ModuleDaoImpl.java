package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Module;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("moduleDao")
public class ModuleDaoImpl extends GenericDaoImpl<Module> implements ModuleDao {

    public ModuleDaoImpl() {
        super(Module.class);
    }

    public List<Module> read(String omschrijving) {
        String sql = "SELECT m FROM Module m WHERE m.omschrijving = :omschrijving";
        Query query = getSession().createQuery(sql).setParameter("omschrijving", omschrijving);
        if (query.list().isEmpty()) {
            return null;
        }
        return(List<Module>)query.list();
    }

}