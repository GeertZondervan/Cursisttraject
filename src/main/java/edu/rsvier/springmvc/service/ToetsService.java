package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.Toets;
import java.util.List;

public interface ToetsService {

    void create(Toets toets) throws IllegalArgumentException;

    void update(Toets toets);

    Toets read(int id) throws NullPointerException;

    void delete(Toets toets);

    List<Toets> getAll();

    void flushSession();
}
