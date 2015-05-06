package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.Materiaal;
import java.util.List;
 
public interface MateriaalService {
 
    void create(Materiaal materiaal);
    
    void update(Materiaal materiaal);
     
    List<Materiaal> getAll(); 
   
    List<Materiaal> read(String titel);

    void delete(Materiaal materiaal);
   
    Materiaal read(int id);
    
    void flushSession();
}