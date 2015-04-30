
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.dao.RolDao;
import edu.rsvier.springmvc.dao.ToetsDao;
import edu.rsvier.springmvc.model.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("rolService")
@Transactional
public class RolServiceImpl implements RolService {
    @Autowired
    private RolDao dao;

    public void create(Rol rol) {
        dao.create(rol);
    }

    public void update(Rol rol) {
        dao.update(rol);
    }

    public Rol read(int id) {
       return ((Rol)dao.read(id));
    }

    public void delete(Rol rol) {
       dao.delete(rol);
    }

    public List<Rol> getAll() {
        return dao.getAll();
    }
    
}
