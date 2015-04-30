package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Expertise;
import java.util.List;

public interface ExpertiseDao {

    void create(Expertise expertise);

    void update(Expertise expertise);

    Expertise read(int id);

    Expertise getExpertise(String naam);

    void delete(Expertise expertise);

    List<Expertise> getAll();
}
