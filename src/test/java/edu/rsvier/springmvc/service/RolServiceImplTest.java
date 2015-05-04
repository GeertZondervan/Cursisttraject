package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Rol;
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
public class RolServiceImplTest {
    
    @Autowired
    private RolService service;
    private Rol rol;
    private Rol rol2;
  
    @Before
    public void setUp() {
        rol = PojoGenerator.getRol();
        service.create(rol);
        
        rol2 = PojoGenerator.getRol();
 
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class RolServiceImpl.
     */
    @Test
    @Transactional
    public void testCreate() {
        service.create(rol2);
        
        Rol result = (Rol)service.read(rol2.getId());
                
        assertNotNull("rol must not be null", rol2);
        assertNotNull("result must not be null", result);
        
        assertEquals("rol, all fields must be equal", rol2, result);
    }

    /**
     * Test of update method, of class RolServiceImpl.
     */
    @Test
    @Transactional
    public void testUpdate() {
        int id = rol.getId();
        
        Rol result = (Rol)service.read(id);
        result.setNaam("Java Dev2");
        service.update(result);
        
        rol = service.read(id);
        
        assertNotNull("result must not be null", rol);
        
        assertEquals("rol, all fields must be equal", rol, result);
    }

    /**
     * Test of read method, of class RolServiceImpl.
     */
    @Test
    @Transactional
    public void testRead_int() {
        Rol result = (Rol)service.read(rol.getId());
                
        assertNotNull("rol must not be null", rol);
        assertNotNull("result must not be null", result);
        
        assertEquals("rol, all fields must be equal", rol, result);
    }


    /**
     * Test of delete method, of class RolServiceImpl.
     */
    @Test
    @Transactional
    public void testDelete() {
        int id = rol.getId();
        service.delete(rol);
        
        Rol result = service.read(id);
        assertNull("Result is null, object has been deleted", result);
        
    }

    /**
     * Test of getAll method, of class RolServiceImpl.
     */
    @Test
    @Transactional
    public void testGetAll() {
        service.create(rol2);
        
        List<Rol> resultList = service.getAll();
        assertNotNull("resultList must not be null", resultList);
        
        assertTrue("rol must be in the resultList", resultList.contains(rol)); 
        assertTrue("rol2 must be in the resultList", resultList.contains(rol2)); 
        
        
       
    }
    
}
