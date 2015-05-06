package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.model.Toets;
import org.springframework.stereotype.Repository;

@Repository("toetsDao")
public class ToetsDaoImpl extends GenericDaoImpl<Toets> implements ToetsDao {

    public ToetsDaoImpl() {
        super(Toets.class);
    }

}
