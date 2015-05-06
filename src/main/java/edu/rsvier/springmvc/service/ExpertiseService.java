
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.Expertise;
import java.util.List;
 
public interface ExpertiseService {
 
    void create(Expertise expertise);
    
    void update(Expertise expertise);
     
    List<Expertise> getAll(); 
   
    List<Expertise> read(String naam);

    void delete(Expertise expertise);
   
    Expertise read(int id);
    
    void flushSession();
}