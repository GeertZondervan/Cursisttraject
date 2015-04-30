package edu.rsvier.springmvc.dao;

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
public class BestandDaoImplTest {
    
    @Autowired
    private BestandDao dao;

    private Bestand bestand;
    
    @Before
    public void setUp() {
       bestand = new Bestand();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    @Transactional
    public void testCreate() {
        System.out.println("creating bestand");
        
        assertNotNull("bestand, must not be null", bestand);

    }
}
