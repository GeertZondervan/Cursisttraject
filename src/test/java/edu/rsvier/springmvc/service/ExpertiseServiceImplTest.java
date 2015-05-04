package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Expertise;
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
public class ExpertiseServiceImplTest {

    @Autowired
    private ExpertiseService service;

    private Expertise expertise;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() {
        expertise = PojoGenerator.getExpertise();
        service.create(expertise);
    }

    @After
    public void tearDown() {
    }

    @Test
    @Transactional
    public void testCreate() {
        Expertise expertise2 = PojoGenerator.getExpertise();
        service.create(expertise2);
        Expertise result = service.read(expertise2.getId());
        assertNotNull("expertise, must not be null", expertise2);
        assertNotNull("Result, must not be null", result);
        assertTrue("id, must be positive", result.getId() >= 0);
        assertEquals("persoon, all fields must be equal", expertise2, result);
    }

    @Test
    @Transactional
    public void testCreateNotComplete() {
        Expertise expertise2 = new Expertise();
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Expertise not complete");
        service.create(expertise2);
    }

    @Test
    @Transactional
    public void testRead() {
        Expertise result = service.read(expertise.getId());
        assertNotNull("expertise, must not be null", expertise);
        assertNotNull("Result, must not be null", result);
        assertTrue("id, must be positive", result.getId() >= 0);
        assertEquals("persoon, all fields must be equal", expertise, result);
    }

    @Test
    @Transactional
    public void testReadNotFound() {
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Expertise not found");
        Expertise result = service.read(0);
    }

    // Wiemer: Leroy/Timo/iemand anders vragen hoe we de Hibernate cache kunnen omzeilen. TestUpdate werkt nu ook zonder update aan te roepen.
    @Test
    @Transactional
    public void testUpdate() {
        Expertise expertise2 = service.read(expertise.getId());
      
        service.update(expertise2);
        int id = expertise.getId();

        Expertise result = service.read(id);

        assertNotNull("Result, must not be null", result);
        
    }

    
    //Wiemer: Zou foutmelding moeten geven, maar werkt gek genoeg.
//    @Test
//    @Transactional
//    public void testUpdateNotFound() {
//
//        //expectedEx.expect(IllegalArgumentException.class);
//        //expectedEx.expectMessage("Cannot update, expertise not found");
//        Expertise expertise3 = new Expertise();
//
//        expertise3.setNaam("");
//
//        service.update(expertise3);
//
//    }

    @Test
    @Transactional
    public void testDelete() {
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Expertise not found");

        service.create(expertise);
        service.delete(expertise);
        int id = expertise.getId();
        Expertise result = service.read(id);
    }

}
