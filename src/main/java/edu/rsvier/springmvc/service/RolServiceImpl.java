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

    public void create(Rol rol) throws IllegalArgumentException {
        if (rol.getNaam() == null) {
            throw new IllegalArgumentException("Rol not complete");
        }
        dao.create(rol);
    }

    public Rol read(int id) throws NullPointerException {
        Rol rol = dao.read(id);
        if (rol == null) {
            throw new NullPointerException("Rol not found");
        }
        return rol;
    }

    public void update(Rol rol) {
        dao.update(rol);
    }

    public void delete(Rol rol) {
        dao.delete(rol);
    }

    public List<Rol> getAll() {
        return dao.getAll();
    }

    public void flushSession() {
        dao.flushSession();
    }

    public Rol read(String naam) throws NullPointerException {
        return dao.read(naam).get(0);
    }
    

}
