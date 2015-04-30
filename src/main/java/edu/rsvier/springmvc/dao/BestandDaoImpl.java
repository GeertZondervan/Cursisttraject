package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Bestand;

import org.springframework.stereotype.Repository;

@Repository("bestandDao")
public class BestandDaoImpl extends GenericDaoImpl<Bestand> implements BestandDao {

    public BestandDaoImpl() {
        super(Bestand.class);
    }

}
