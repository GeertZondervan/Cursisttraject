package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Materiaal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
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
public class MateriaalServiceImplTest {

    @Autowired
    private MateriaalService service;

    private Materiaal materiaal;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() {
        materiaal = PojoGenerator.getMateriaal();
        service.create(materiaal);
    }

    @After
    public void tearDown() {
    }

    @Test
    @Transactional
    public void testCreate() {
        Materiaal materiaal2 = PojoGenerator.getMateriaal();
        service.create(materiaal2);
        service.flushSession();
        Materiaal result = service.read(materiaal2.getId());

        assertNotNull("materiaal, must not be null", materiaal2);
        assertNotNull("Result, must not be null", result);
        assertTrue("id, must be positive", result.getId() >= 0);
        assertEquals("persoon, all fields must be equal", materiaal2, result);
    }

    @Test
    @Transactional
    public void testCreateNotComplete() {
        Materiaal materiaal2 = new Materiaal();
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Materiaal not complete");
        service.create(materiaal2);
    }

    @Test
    @Transactional
    public void testRead() {
        service.flushSession();
        Materiaal result = service.read(materiaal.getId());
        assertNotNull("materiaal, must not be null", materiaal);
        assertNotNull("Result, must not be null", result);
        assertTrue("id, must be positive", result.getId() >= 0);
        assertEquals("persoon, all fields must be equal", materiaal, result);
    }

    @Test
    @Transactional
    public void testReadNotFound() {
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Materiaal not found");
        Materiaal result = service.read(0);
    }

    @Test
    @Transactional
    public void testUpdate() {
        Materiaal materiaal2 = service.read(materiaal.getId());
        materiaal2.setAuteur("Osama bin Laden");
        service.update(materiaal2);
        service.flushSession();
        
        Materiaal result = service.read(materiaal.getId());

        assertNotNull("Result, must not be null", result);
        assertEquals("result & materiaal2, all fields must be equal", materiaal2, result);
        assertTrue("New Autuur, must be Osama bin Laden", result.getAuteur().equals("Osama bin Laden"));
    }


    @Test
    @Transactional
    public void testDelete() {
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Materiaal not found");

        service.create(materiaal);
        service.delete(materiaal);
        service.flushSession();
        int id = materiaal.getId();
        Materiaal result = service.read(id);
    }

}
