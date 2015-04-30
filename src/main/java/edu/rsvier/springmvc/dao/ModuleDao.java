package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Module;
import java.util.List;

public interface ModuleDao {

    void create(Module module);

    void update(Module module);

    Module read(int id);

    void delete(Module module);

    List<Module> getAll();
    
    List<Module> read(String omschrijving);
}
