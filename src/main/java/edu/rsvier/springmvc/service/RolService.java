
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.Rol;
import java.util.List;

public interface RolService {
     void create(Rol rol);

    void update(Rol rol);

    Rol read(int id);

    void delete(Rol rol);

    List<Rol> getAll();
}
