
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.dao.ToetsResultaatDao;
import edu.rsvier.springmvc.model.ToetsResultaat;
import edu.rsvier.springmvc.model.ToetsResultaatId;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("toetsResultaatService")
@Transactional
public class ToetsResultaatServiceImpl implements ToetsResultaatService {

    @Autowired
    private ToetsResultaatDao dao;
    
    public void create(ToetsResultaat toetsResultaat) {
        dao.create(toetsResultaat);
    }

    public void update(ToetsResultaat toetsResultaat) {
       dao.update(toetsResultaat);
    }

    public ToetsResultaat read(ToetsResultaatId id) {
       return ((ToetsResultaat)dao.read(id));
    }

    public void delete(ToetsResultaat toetsResultaat) {
       dao.delete(toetsResultaat);
    }

    public List<ToetsResultaat> getAll() {
        return dao.getAll();
    }
    
    
}
