package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Materiaal;
import edu.rsvier.springmvc.model.Persoon;
import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.PersoonsrolHasMateriaal;
import edu.rsvier.springmvc.model.PersoonsrolHasMateriaalId;
import edu.rsvier.springmvc.model.Rol;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppInitializer.class, AppConfig.class, HibernateConfiguration.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@WebAppConfiguration
public class PersoonsrolMateriaalServiceImplTest {
    
    @Autowired
    private PersoonsrolMateriaalService service; 
    @Autowired
    private PersoonsrolService persoonsrolService;
    @Autowired 
    MateriaalService materiaalService;
    @Autowired
    PersoonService persoonService;     
    @Autowired
    RolService rolService;   
    private PersoonsrolHasMateriaal hasMat;
    
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
       
    @Before
    public void setUp() {
        Persoon persoon = PojoGenerator.getPersoon();
        persoonService.create(persoon);

        Rol rol = PojoGenerator.getRol();
        rolService.create(rol);

        Persoonsrol persoonsrol = PojoGenerator.getPersoonsrol(persoon, rol);
        persoonsrolService.create(persoonsrol);
        
        Materiaal materiaal = PojoGenerator.getMateriaal();
        materiaalService.create(materiaal);
        
        hasMat = PojoGenerator.getPersoonsrolHasMateriaal(materiaal, persoonsrol);

    }
    
    @After
    public void tearDown() {
    }

//    @Test
//    public void testCreate() {
//        service.flushSession();
//        PersoonsrolHasMateriaal result = service.read(hasMat.getId());
//        assertNotNull("result must not be null", result);
//        assertEquals("Persoonsrol must be equal", hasMat.getPersoonsrol(), result.getPersoonsrol());
//        assertEquals("Materiaal must be equal", hasMat.getMateriaal(), result.getMateriaal());
//    }

//    @Test
//    public void testUpdate() {
//        System.out.println("update");
//        PersoonsrolHasMateriaal hasMat = null;
//        PersoonsrolMateriaalServiceImpl instance = new PersoonsrolMateriaalServiceImpl();
//        instance.update(hasMat);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    @Test
    public void testRead() {
        service.create(hasMat);
        PersoonsrolHasMateriaalId id = hasMat.getId();
        service.flushSession();
        PersoonsrolHasMateriaal result = service.read(id);
        assertNotNull("result must not be null", result);
        System.out.println("/////" + hasMat.getPersoonsrol());
        System.out.println("/////" + result.getPersoonsrol());
//        assertEquals("Persoonsrol must be equal", hasMat.getPersoonsrol(), result.getPersoonsrol());
//        assertEquals("Materiaal must be equal", hasMat.getMateriaal(), result.getMateriaal());
    }

//    @Test
//    public void testDelete() {
//    }
//
//    @Test
//    public void testGetAll() {
//    }   
}
