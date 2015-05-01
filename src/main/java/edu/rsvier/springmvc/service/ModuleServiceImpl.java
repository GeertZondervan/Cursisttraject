package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.dao.ModuleDao;
import edu.rsvier.springmvc.model.Module;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("moduleService")
@Transactional
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleDao dao;

    public void create(Module module) throws IllegalArgumentException {
        if (module.getTraject() == null) {
            throw new IllegalArgumentException("Module not complete");
        }
        dao.create(module);
    }

    public Module read(int id) throws NullPointerException {
        Module module = dao.read(id);
        if (module == null) {
            throw new NullPointerException("Module not found");
        }

        return module;
    }

    public void update(Module module) {
        dao.update(module);
    }

    public void delete(Module module) {
        dao.delete(module);
    }

    public List<Module> getAll() {
        return dao.getAll();
    }

    public List<Module> read(String omschrijving) {
        return dao.read(omschrijving);
    }
}