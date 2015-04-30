package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Persoon;
import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.Rol;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppInitializer.class, AppConfig.class, HibernateConfiguration.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@WebAppConfiguration
public class RolDaoImplTest {

    @Autowired
    private RolDao dao;
    private Rol rol;

    @Before
    public void setUp() {
        rol = new Rol();
        rol.setNaam("Cursist");

        Persoon persoon = new Persoon();
        persoon.setVoornaam("Karel");
        persoon.setAchternaam("Appel");

        Persoonsrol persoonsRol = new Persoonsrol();
        persoonsRol.setPersoon(persoon);
        persoonsRol.setRol(rol);
        persoonsRol.setEinddatum(new Date());

        rol.getPersoonsrollen().add(persoonsRol);

    }

    @After
    public void tearDown() {
    }

    @Test
    @Transactional
    public void testCreate() {
        System.out.println("creating Rol");
        dao.create(rol);

        Rol result = (Rol) dao.read(rol.getId());

        assertNotNull("rol must not be null", rol);
        assertNotNull("result must not be null", result);

        assertEquals("rol, all fields must be equal", rol, result);

    }

    @Test
    @Transactional
    public void testUpdate() {
        System.out.println("updating rol");
        dao.create(rol);
        int id = rol.getId();
        rol = null;

        Rol result = (Rol) dao.read(id);
        result.setNaam("Trainee");

        dao.update(result);
        String naam = result.getNaam();
        result = null;

        result = dao.read(id);

        assertNotNull("result must not be null", result);

        assertEquals("traject, all name fields must be equal", result.getNaam(), naam);
    }

    @Test
    @Transactional
    public void testRead() {
        System.out.println("reading rol");
        dao.create(rol);

        Rol result = (Rol) dao.read(rol.getId());

        assertNotNull("traject must not be null", rol);
        assertNotNull("result must not be null", result);

        assertEquals("traject, all fields must be equal", rol, result);
    }

    @Test
    @Transactional
    public void testDelete() {
        System.out.println("deleting rol");
        dao.create(rol);
        int id = rol.getId();
        dao.delete(rol);
        Rol result = dao.read(id);
        assertNull("Result is null, object has been deleted", result);

    }

}
