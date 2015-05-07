package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Traject;
import java.util.List;
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
public class TrajectServiceImplTest {
    
    @Autowired
    private TrajectService service;
    private Traject traject;
    private Traject traject2;
    
    
     @Rule
    public ExpectedException expectedEx = ExpectedException.none();
  
    @Before
    public void setUp() {
        traject = PojoGenerator.getTraject();
        service.create(traject);
        System.out.println();
        traject2 = PojoGenerator.getTraject();
 
    }
    
    @After
    public void tearDown() {
    }

    @Test
    @Transactional
    public void testCreate() {
        service.create(traject2);
        service.flushSession();
        Traject result = (Traject)service.read(traject2.getId());
                
        assertNotNull("traject must not be null", traject2);
        assertNotNull("result must not be null", result);
        assertEquals("traject, all fields must be equal", traject2, result);
    }

    @Test
    @Transactional
    public void testUpdate() {
        
        int id = traject.getId();
        
        Traject result = (Traject)service.read(id);
        result.setNaam("Java Dev2");
        service.update(result);
        service.flushSession();
        traject = service.read(id);
        assertNotNull("result must not be null", traject);
        assertEquals("traject, all fields must be equal", traject, result);
    }

    @Test
    @Transactional
    public void testRead_int() {
        service.create(traject);
        service.flushSession();
        
        Traject result = (Traject)service.read(traject.getId()); 
        assertNotNull("traject must not be null", traject);
        assertNotNull("result must not be null", result);
        assertEquals("traject, all fields must be equal", traject, result);
    }

    @Test
    @Transactional
    public void testRead_String() {
        service.create(traject2);
        
        Traject traject3 = PojoGenerator.getTraject();
        service.create(traject3);
        service.flushSession();
        List<Traject> lijst = service.read("Basistraject");
        
        assertNotNull("Lijst, is not null", lijst);
        assertTrue("lijst contains traject", lijst.contains(traject));
        assertTrue("lijst contains traject2", lijst.contains(traject2));
        assertTrue("lijst contains traject3", lijst.contains(traject3));
        
    }

    @Test
    @Transactional
    public void testDelete() {
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Traject not found");
        
        int id = traject.getId();
        service.delete(traject);
        service.flushSession();
        Traject result = service.read(id);
 
    }

    @Test
    @Transactional
    public void testGetAll() {
        service.create(traject2);
        service.flushSession();
        List<Traject> resultList = service.getAll();
        assertNotNull("resultList must not be null", resultList);
        
        assertTrue("traject must be in the resultList", resultList.contains(traject)); 
        assertTrue("traject2 must be in the resultList", resultList.contains(traject2)); 
        
        
       
    }
    
}
