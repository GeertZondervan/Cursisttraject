package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.PersoonsrolId;
import java.util.List;

public interface PersoonsrolDao {

    void create(Persoonsrol persoonsrol);

    void update(Persoonsrol persoonsrol);

    Persoonsrol read(PersoonsrolId id);

    void delete(Persoonsrol persoonsrol);
    
    void flushSession();

    public Persoonsrol read(int persoonId, int rolId);
    
    public List<Persoonsrol>getAll();


}
