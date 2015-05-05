package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Module;
import edu.rsvier.springmvc.model.Toets;
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
public class ToetsServiceImplTest {
    
     @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    
    @Autowired
    private ToetsService service;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private TrajectService trajectService;
    private Toets toets;
    private Toets toets2;
  
    @Before
    public void setUp() {
        Traject traject = PojoGenerator.getTraject();
        trajectService.create(traject);
        
        Module module = PojoGenerator.getModule(traject);
        moduleService.create(module);
        
        toets = PojoGenerator.getToets(module);
        service.create(toets);
        
        toets2 = PojoGenerator.getToets(module);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ToetsServiceImpl.
     */
    @Test
    @Transactional
    public void testCreate() {
        service.create(toets2);
        
        Toets result = (Toets)service.read(toets2.getId());
        int toetsId = result.getId();
        
        assertNotNull("toets must not be null", toets2);
        assertNotNull("result must not be null", result);
        
        assertEquals("toets, all fields must be equal", toets2, result);
    }

    /**
     * Test of update method, of class ToetsServiceImpl.
     */
    @Test
    @Transactional
    public void testUpdate() {
        int id = toets.getId();
        
        Toets result = (Toets)service.read(id);
        result.setNaam("Java MYSQL toets");
        service.update(result);
        
        toets = service.read(id);
        
        assertNotNull("result must not be null", toets);
        
        assertEquals("toets, all fields must be equal", toets, result);
    }

    /**
     * Test of read method, of class ToetsServiceImpl.
     */
    @Test
    @Transactional
    public void testRead_int() {
        Toets result = (Toets)service.read(toets.getId());
        int toetsId = result.getId();
        
        assertNotNull("toets must not be null", toets);
        assertNotNull("result must not be null", result);
        
        assertEquals("toets, all fields must be equal", toets, result);
    }

    
    /**
     * Test of delete method, of class ToetsServiceImpl.
     */
    @Test
    @Transactional
    public void testDelete() {
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Toets not found");
        int id = toets.getId();
        service.delete(toets);
        
        Toets result = service.read(id);
        assertNull("Result is null, object has been deleted", result);
        
    }

    /**
     * Test of getAll method, of class ToetsServiceImpl.
     */
    @Test
    @Transactional
    public void testGetAll() {
        service.create(toets2);
        
        List<Toets> resultList = service.getAll();
        assertNotNull("resultList must not be null", resultList);
        
        assertTrue("toets must be in the resultList", resultList.contains(toets)); 
        assertTrue("toets2 must be in the resultList", resultList.contains(toets2)); 
        
        
       
    }
    
}
