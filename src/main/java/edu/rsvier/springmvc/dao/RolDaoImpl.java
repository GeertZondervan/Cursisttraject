package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Rol;
import org.springframework.stereotype.Repository;
@Repository("rolDao")
public class RolDaoImpl extends GenericDaoImpl<Rol> implements RolDao {

    public RolDaoImpl() {
        super(Rol.class);
    }
    
}
