package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Bestand;
import edu.rsvier.springmvc.model.Expertise;
import edu.rsvier.springmvc.model.Persoon;
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
        bestand = new Bestand();
        bestand.setBestand(new byte[2]);
    }

    @After
    public void tearDown() {
    }

    @Test
    @Transactional
    public void testCreate() {
        service.create(bestand);
        Bestand result = service.read(bestand.getId());
        System.out.println(result);
        assertNotNull("bestand, must not be null", bestand);
        assertNotNull("Result, must not be null", result);
        assertTrue("id, must be positive", result.getId() >= 0);
        assertEquals("persoon, all fields must be equal", bestand, result);
    }

    @Test
    @Transactional
    public void testCreateNotComplete() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Bestand not complete");
        bestand.setBestand(null);
        service.create(bestand);
        bestand.setBestand(new byte[3]);
    }

    @Test
    @Transactional
    public void testRead() {
        service.create(bestand);
        Bestand result = service.read(bestand.getId());
        System.out.println(result);
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
        Bestand result = service.read(1111);
    }

    // Wiemer: Leroy/iemand anders vragen hoe we de Hibernate cache kunnen omzeilen. TestUpdate werkt nu ook zonder update aan te roepen.
    @Test
    @Transactional
    public void testUpdate() {

        service.create(bestand);
        bestand.setBestand(new byte[5]);
        service.update(bestand);

        int id = bestand.getId();

        Bestand result = service.read(id);

        assertNotNull("Result, must not be null", result);
        assertTrue("Bestandlengte, must be 5", result.getBestand().length == 5);
    }

    @Test
    @Transactional
    public void testUpdateNotFound() {
        Bestand bestand3 = new Bestand();
        bestand3.setBestand(new byte[42]);
        System.out.println(bestand3);
        service.update(bestand3);
        service.read(bestand3.getId());
        System.out.println(bestand3);
    }

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
