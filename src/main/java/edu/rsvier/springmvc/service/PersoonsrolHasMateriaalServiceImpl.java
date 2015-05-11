package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.dao.PersoonsrolHasMateriaalDao;
import edu.rsvier.springmvc.model.PersoonsrolHasMateriaal;
import edu.rsvier.springmvc.model.PersoonsrolHasMateriaalId;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("persoonsrolMateriaalService")
@Transactional
public class PersoonsrolHasMateriaalServiceImpl implements PersoonsrolHasMateriaalService {

    @Autowired
    private PersoonsrolHasMateriaalDao dao;

    public void create(PersoonsrolHasMateriaal hasMat) throws IllegalArgumentException {
        if (hasMat.getMateriaal() == null || hasMat.getPersoonsrol() == null) {
            throw new IllegalArgumentException("PersoonsrolHasMateriaal not complete");
        }
        dao.create(hasMat);
    }

    public void update(PersoonsrolHasMateriaal hasMat) {
        dao.update(hasMat);
    }

    public PersoonsrolHasMateriaal read(PersoonsrolHasMateriaalId id) throws NullPointerException {
        PersoonsrolHasMateriaal perMat = dao.read(id);
        if (perMat == null) {
            throw new NullPointerException("ToetsResultaat not found");
        }

        return perMat;
    }

    public void delete(PersoonsrolHasMateriaal hasMat) {
        dao.delete(hasMat);
    }

    public List<PersoonsrolHasMateriaal> getAll() {
        return dao.getAll();
    }

    public void flushSession() {
        dao.flushSession();
    }

}
