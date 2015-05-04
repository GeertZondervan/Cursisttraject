package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Bestand;
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
public class BestandServiceImplTest {

    @Autowired
    private BestandService service;

    private Bestand bestand;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() {
        bestand = PojoGenerator.getBestand();
        service.create(bestand);
    }

    @After
    public void tearDown() {
    }

    @Test
    @Transactional
    public void testCreate() {
        Bestand bestand2 = PojoGenerator.getBestand();
        service.create(bestand2);
        service.flushSession();
        Bestand result = service.read(bestand2.getId());
        assertNotNull("bestand, must not be null", bestand2);
        assertNotNull("Result, must not be null", result);
        assertTrue("id, must be positive", result.getId() >= 0);
        assertEquals("bestand, all fields must be equal", bestand2, result);
    }

    @Test
    @Transactional
    public void testCreateNotComplete() {
        Bestand bestand2 = new Bestand();
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Bestand not complete");
        service.create(bestand2);
    }

    @Test
    @Transactional
    public void testRead() {
        service.flushSession();
        Bestand result = service.read(bestand.getId());
        assertNotNull("bestand, must not be null", bestand);
        assertNotNull("Result, must not be null", result);
        assertTrue("id, must be positive", result.getId() >= 0);
        assertEquals("persoon, all fields must be equal", bestand, result);
    }

    @Test
    @Transactional
    public void testReadNotFound() {
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Bestand not found");
        Bestand result = service.read(0);
    }

    @Test
    @Transactional
    public void testUpdate() {
        bestand.setBestand(new byte[5]);
        service.update(bestand);
        service.flushSession();

        Bestand result = service.read(bestand.getId());
        assertNotNull("Result, must not be null", result);
        assertTrue("Bestandlengte, must be 5", result.getBestand().length == 5);
    }

//    @Test
//    @Transactional
//    public void testUpdateNotFound() {
//
//        expectedEx.expect(IllegalArgumentException.class);
//        expectedEx.expectMessage("Cannot update, bestand not found");
//        Bestand bestand3 = new Bestand();
//
//        bestand3.setBestand(new byte[42]);
//        service.update(bestand3);
//    }

    @Test
    @Transactional
    public void testDelete() {
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Bestand not found");

        service.create(bestand);
        service.delete(bestand);
        int id = bestand.getId();
        Bestand result = service.read(id);
    }

}
