package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Persoon;
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
public class PersoonDaoImplTest {
    
    @Autowired
    private PersoonDaoImpl dao;
    private Persoon persoon;
       
    @Before
    public void setUp() {
        persoon = new Persoon();
        persoon.setVoornaam("Ali");
        persoon.setAchternaam("Chemicali");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    @Transactional
    public void testCreate() {
        System.out.println("creating terrorist");
        dao.create(persoon);
        Persoon result = dao.getPersoon("Ali", "Chemicali");
        int persoonId = result.getId();
        
        assertNotNull("persoon, must not be null", persoon);
        assertNotNull("Result, must not be null", result);
        assertTrue("id, must be positive", persoonId >= 0);

        assertEquals("persoon, all fields must be equal", persoon, result);
    }
}
