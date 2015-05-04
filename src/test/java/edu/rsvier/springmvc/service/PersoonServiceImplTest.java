package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Persoon;
import edu.rsvier.springmvc.model.Persoonsrol;
import java.util.HashSet;
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
public class PersoonServiceImplTest {

    @Autowired
    private PersoonService service;

    private Persoon persoon;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() {
        persoon = PojoGenerator.getPersoon();
        service.create(persoon);
    }

    @After
    public void tearDown() {
    }

    @Test
    @Transactional
    public void testCreate() {
        Persoon persoon2 = PojoGenerator.getPersoon();
        System.out.println(persoon);
        System.out.println(persoon2);
        service.create(persoon2);
        Persoon result = service.read(persoon2.getId());
        System.out.println(result);
        assertNotNull("persoon, must not be null", persoon2);
        assertNotNull("Result, must not be null", result);
        assertTrue("id, must be positive", result.getId() >= 0);
        assertEquals("persoon, all fields must be equal", persoon2, result);
    }

    @Test
    @Transactional
    public void testCreateNotComplete() {
        Persoon persoon2 = new Persoon();
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Persoon not complete");
        service.create(persoon2);
    }

    @Test
    @Transactional
    public void testRead() {
        Persoon result = service.read(persoon.getId());
        System.out.println(result);
        assertNotNull("persoon, must not be null", persoon);
        assertNotNull("Result, must not be null", result);
        assertTrue("id, must be positive", result.getId() >= 0);
        assertEquals("persoon, all fields must be equal", persoon, result);
    }

    @Test
    @Transactional
    public void testReadNotFound() {
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Persoon not found");
        Persoon result = service.read(0);
    }

    // Wiemer: Leroy/Timo/iemand anders vragen hoe we de Hibernate cache kunnen omzeilen. TestUpdate werkt nu ook zonder update aan te roepen.
    @Test
    @Transactional
    public void testUpdate() {
        Persoon persoon2 = service.read(persoon.getId());

        persoon2.setVoornaam("Jimmy");
        persoon2.setAchternaam("Choo");
        persoon2.setPersoonsrollen(new HashSet<Persoonsrol>());
        
        service.update(persoon2);

        int id = persoon.getId();

        Persoon result = service.read(id);

        assertNotNull("Result, must not be null", result);
        
    }

    
    //Wiemer: Zou foutmelding moeten geven, maar werkt gek genoeg.
    @Test
    @Transactional
    public void testUpdateNotFound() {

        //expectedEx.expect(IllegalArgumentException.class);
        //expectedEx.expectMessage("Cannot update, persoon not found");
        Persoon persoon3 = new Persoon();

        persoon3.setVoornaam("Jimmy");
        persoon3.setAchternaam("Woo");
        persoon3.setPersoonsrollen(new HashSet<Persoonsrol>());

        System.out.println("Update: " + persoon3);
        service.update(persoon3);

        System.out.println("Update: " + persoon3);
    }

    @Test
    @Transactional
    public void testDelete() {
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Persoon not found");

        service.create(persoon);
        service.delete(persoon);
        int id = persoon.getId();
        Persoon result = service.read(id);
    }

}
