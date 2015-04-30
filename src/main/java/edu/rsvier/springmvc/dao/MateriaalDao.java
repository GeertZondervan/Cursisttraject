package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Materiaal;
import java.util.List;

public interface MateriaalDao {

    void create(Materiaal materiaal);

    void update(Materiaal materiaal);

    Materiaal read(int id);

    void delete(Materiaal materiaal);

    List<Materiaal> getAll();
    
    List<Materiaal> read(String titel);
    
}
