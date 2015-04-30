package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.dao.MateriaalDao;
import edu.rsvier.springmvc.model.Materiaal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("materiaalService")
@Transactional
public class MateriaalServiceImpl implements MateriaalService {

    @Autowired
    private MateriaalDao dao;

    public void create(Materiaal materiaal) {
        dao.create(materiaal);
    }

    public Materiaal read(int id) {
        return ((Materiaal) dao.read(id));
    }

    public void update(Materiaal materiaal) {
        dao.update(materiaal);
    }

    public void delete(Materiaal materiaal) {
        dao.delete(materiaal);
    }

    public List<Materiaal> getAll() {
        return dao.getAll();
    }

    public List<Materiaal> read(String titel) {
        return dao.read(titel);
    }
}