package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.Traject;
import java.util.List;

public interface TrajectService {

    void create(Traject traject) throws IllegalArgumentException;

    void update(Traject traject);

    Traject read(int id) throws NullPointerException;

    List<Traject> read(String naam);

    void delete(Traject traject);

    List<Traject> getAll();

    void flushSession();

}
