package edu.rsvier.springmvc.service;

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
public class TrajectServiceImplTest {
    
    @Autowired
    private TrajectService service;
    private Traject traject;
    private Traject traject2;
  
    @Before
    public void setUp() {
        traject = new Traject();
        traject.setNaam("Java Developer");
        traject.setOmschrijving("Opleiding tot Java Developer");
        traject.setStartdatum(new Date());
        service.create(traject);
        
        traject2 = new Traject();
        traject2.setNaam("C++ Developer");
        traject2.setOmschrijving("Opleiding tot C++ developer");
        traject2.setStartdatum(new Date());
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class TrajectServiceImpl.
     */
    @Test
    @Transactional
    public void testCreate() {
        System.out.println("creating traject");
        service.create(traject2);
        
        Traject result = (Traject)service.read(traject2.getId());
        int trajectId = result.getId();
        
        assertNotNull("traject must not be null", traject2);
        assertNotNull("result must not be null", result);
        
        assertEquals("traject, all fields must be equal", traject2, result);
    }

    /**
     * Test of update method, of class TrajectServiceImpl.
     */
    @Test
    @Transactional
    public void testUpdate() {
        int id = traject.getId();
        
        Traject result = (Traject)service.read(id);
        result.setNaam("Java Dev2");
        service.update(result);
        
        traject = service.read(id);
        
        assertNotNull("result must not be null", traject);
        
        assertEquals("traject, all fields must be equal", traject, result);
    }

    /**
     * Test of read method, of class TrajectServiceImpl.
     */
    @Test
    @Transactional
    public void testRead_int() {
        System.out.println("creating traject");
        service.create(traject);
        
        Traject result = (Traject)service.read(traject.getId());
        int trajectId = result.getId();
        
        assertNotNull("traject must not be null", traject);
        assertNotNull("result must not be null", result);
        
        assertEquals("traject, all fields must be equal", traject, result);
    }

    /**
     * Test of read method, of class TrajectServiceImpl.
     */
    @Test
    @Transactional
    public void testRead_String() {
        service.create(traject);
        Traject traject2 = new Traject();
        traject2.setNaam("Java Developer");
        traject2.setOmschrijving("Opleiding tot Java Developer nieuwe versie");
        traject2.setStartdatum(new Date());
        service.create(traject2);
        
        Traject traject3 = new Traject();
        traject3.setNaam("Java Developer 3");
        traject3.setOmschrijving("Opleiding tot Java Developer nieuwe versie");
        traject3.setStartdatum(new Date());
        service.create(traject3);
        
        List<Traject> lijst = service.read("Java Developer");
        System.out.println(lijst);
        
        assertNotNull("Lijst, is not null", lijst);
    }

    /**
     * Test of delete method, of class TrajectServiceImpl.
     */
    @Test
    @Transactional
    public void testDelete() {
        service.create(traject);
        int id = traject.getId();
        service.delete(traject);
        
        Traject result = service.read(id);
        assertNull("Result is null, object has been deleted", result);
        
    }

    /**
     * Test of getAll method, of class TrajectServiceImpl.
     */
    @Test
    @Transactional
    public void testGetAll() {
        System.out.println("getAll");
        service.create(traject2);
        
        List<Traject> resultList = service.getAll();
        assertNotNull("resultList must not be null", resultList);
        
        assertTrue("traject must be in the resultList", resultList.contains(traject)); 
        assertTrue("traject2 must be in the resultList", resultList.contains(traject2)); 
        
        
       
    }
    
}
