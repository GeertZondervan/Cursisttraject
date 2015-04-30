package edu.rsvier.springmvc.dao;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Traject;
import java.util.Date;
import java.util.List;
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
public class TrajectDaoImplTest {
    
    @Autowired
    private TrajectDao dao;
    private Traject traject;
       
    @Before
    public void setUp() {
        traject = new Traject();
        traject.setNaam("Java Developer");
        traject.setOmschrijving("Opleiding tot Java Developer");
        traject.setStartdatum(new Date());
    }
    
    @After
    public void tearDown() {
    }

    @Test
    @Transactional
    public void testCreate() {
        System.out.println("creating traject");
        dao.create(traject);
        
        Traject result = (Traject)dao.read(traject.getId());
        int trajectId = result.getId();
        
        assertNotNull("traject must not be null", traject);
        assertNotNull("result must not be null", result);
        
        assertEquals("traject, all fields must be equal", traject, result);
    }
    
    @Test
    @Transactional
    public void testUpdate() {
        dao.create(traject);
        int id = traject.getId();
        traject = null;
        
        Traject result = (Traject)dao.read(id);
        result.setNaam("Java Dev2");
     
        dao.update(result);
        String naam = result.getNaam();
        result = null;
        
        result = dao.read(id);
        //int trajectId = result.getId();
        System.out.println(result.getNaam());
        //assertNotNull("traject must not be null", traject);
        assertNotNull("result must not be null", result);
        
        assertEquals("traject, all fields must be equal", result.getNaam(), naam);
        
    }
    
    @Test
    @Transactional
    public void testRead() {
        System.out.println("creating traject");
        dao.create(traject);
        
        Traject result = (Traject)dao.read(traject.getId());
        int trajectId = result.getId();
        
        assertNotNull("traject must not be null", traject);
        assertNotNull("result must not be null", result);
        
        assertEquals("traject, all fields must be equal", traject, result);
    }
    
    @Test
    @Transactional
    public void testDelete() {
        dao.create(traject);
        int id = traject.getId();
        dao.delete(traject);
        System.out.println(traject.getId() + "HALLLOOOOO");
        System.out.println(id + "" + traject.getId() + " " + traject.getNaam() + " hakfdjakfjkldajfkldkad");
        Traject result = dao.read(id);
        assertNull("Result is null, object has been deleted", result);
        
    }
    
    @Test
    @Transactional
    public void testReadReturnList(){
        dao.create(traject);
        Traject traject2 = new Traject();
        traject2.setNaam("Java Developer");
        traject2.setOmschrijving("Opleiding tot Java Developer nieuwe versie");
        traject2.setStartdatum(new Date());
        dao.create(traject2);
        
        Traject traject3 = new Traject();
        traject3.setNaam("Java Developer 3");
        traject3.setOmschrijving("Opleiding tot Java Developer nieuwe versie");
        traject3.setStartdatum(new Date());
        dao.create(traject3);
        
        List<Traject> lijst = dao.read("Java Developer");
        System.out.println(lijst);
        
        assertNotNull("Lijst, is not null", lijst);
    }
    
}
