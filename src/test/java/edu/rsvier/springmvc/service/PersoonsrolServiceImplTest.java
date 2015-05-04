package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.*;
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
public class PersoonsrolServiceImplTest {
    
    @Autowired
    private PersoonsrolService service;
    @Autowired
    PersoonService persoonService;
    @Autowired
    private RolService rolService;
    private Persoonsrol persoonsrol;
    private Persoonsrol persoonsrol2;
  
    @Before
    public void setUp() {
        Persoon persoon = PojoGenerator.getPersoon();
        persoonService.create(persoon);
        
        Rol rol = PojoGenerator.getRol();
        rolService.create(rol);
        
        persoonsrol = PojoGenerator.getPersoonsrol(persoon, rol);
        service.create(persoonsrol);
        
        persoonsrol2 = PojoGenerator.getPersoonsrol(persoon, rol);
 
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class PersoonsrolServiceImpl.
     */
    @Test
    @Transactional
    public void testCreate() {
        service.create(persoonsrol2);
        
        Persoonsrol result = (Persoonsrol)service.read(persoonsrol2.getId());
                
        assertNotNull("persoonsrol must not be null", persoonsrol2);
        assertNotNull("result must not be null", result);
        
        assertEquals("persoonsrol, all fields must be equal", persoonsrol2, result);
    }

    /**
     * Test of update method, of class PersoonsrolServiceImpl.
     */
    @Test
    @Transactional
    public void testUpdate() {
        PersoonsrolId persoonsrolId = persoonsrol.getId();
        Persoonsrol result = (Persoonsrol)service.read(persoonsrolId);
        Rol rol = new Rol();
        rol.setNaam("Trainee");
        result.setRol(rol);
        service.update(result);
        
        persoonsrol = service.read(persoonsrolId);
        
        assertNotNull("result must not be null", persoonsrol);
        
        assertEquals("persoonsrol, all fields must be equal", persoonsrol, result);
    }

    /**
     * Test of read method, of class PersoonsrolServiceImpl.
     */
    @Test
    @Transactional
    public void testRead_int() {
        Persoonsrol result = (Persoonsrol)service.read(persoonsrol.getId());
                
        assertNotNull("persoonsrol must not be null", persoonsrol);
        assertNotNull("result must not be null", result);
        
        assertEquals("persoonsrol, all fields must be equal", persoonsrol, result);
    }


    /**
     * Test of delete method, of class PersoonsrolServiceImpl.
     */
    @Test
    @Transactional
    public void testDelete() {
        PersoonsrolId persoonsrolId = persoonsrol.getId();
        service.delete(persoonsrol);

        Persoonsrol result = service.read(persoonsrolId);
        assertNull("Result is null, object has been deleted", result);

        
    }


}
