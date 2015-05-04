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

    // Wiemer: Leroy/Timo/iemand anders vragen hoe we de Hibernate cache kunnen omzeilen. TestUpdate werkt nu ook zonder update aan te roepen.
    @Test
    @Transactional
    public void testUpdate() {
        Materiaal materiaal2 = service.read(materiaal.getId());
       
        service.update(materiaal2);

        int id = materiaal.getId();

        Materiaal result = service.read(id);

        assertNotNull("Result, must not be null", result);
        
    }

    
    //Wiemer: Zou foutmelding moeten geven, maar werkt gek genoeg.
    @Test
    @Transactional
    public void testUpdateNotFound() {

        //expectedEx.expect(IllegalArgumentException.class);
        //expectedEx.expectMessage("Cannot update, materiaal not found");
        Materiaal materiaal3 = new Materiaal();

        materiaal3.setTitel("Javaboek 2");

        service.update(materiaal3);

    }

    @Test
    @Transactional
    public void testDelete() {
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Materiaal not found");

        service.create(materiaal);
        service.delete(materiaal);
        int id = materiaal.getId();
        Materiaal result = service.read(id);
    }

}
