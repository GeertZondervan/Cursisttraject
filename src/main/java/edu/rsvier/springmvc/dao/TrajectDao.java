package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Traject;
import edu.rsvier.springmvc.model.Traject;
import java.util.List;

public interface TrajectDao {

    void create(Traject traject);

    void update(Traject traject);

    Traject read(int id);

    List<Traject> read(String naam);

    void delete(Traject traject);

    List<Traject> getAll();
}
