
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.Rol;
import java.util.List;

public interface RolService {
     void create(Rol rol)  throws IllegalArgumentException ;

    void update(Rol rol) ;

    Rol read(int id)  throws NullPointerException ;

    void delete(Rol rol);

    List<Rol> getAll();
}
