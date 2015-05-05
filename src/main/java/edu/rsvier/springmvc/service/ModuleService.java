package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.Module;
import java.util.List;
 
public interface ModuleService {
 
    void create(Module module);
    
    void update(Module module);
     
    List<Module> getAll(); 
   
    List<Module> read(String omschrijving);

    void delete(Module module);
   
    Module read(int id);
    
    public void flushSession();
}