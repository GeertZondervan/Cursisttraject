package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Expertise;
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
public class ExpertiseDaoImplTest {
    
    @Autowired
    private ExpertiseDao dao;

    private Expertise expertise;
    
    @Before
    public void setUp() {
        expertise = new Expertise();
        expertise.setModule(null);
        expertise.setNaam("IED's maken");
        expertise.setOmschrijving("Boem maken!");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    @Transactional
    public void testCreate() {
        System.out.println("creating bomb making expertise");
        
        System.out.println(expertise.getId());
        
      
        assertNotNull("expertise, must not be null", expertise);

    }
}
