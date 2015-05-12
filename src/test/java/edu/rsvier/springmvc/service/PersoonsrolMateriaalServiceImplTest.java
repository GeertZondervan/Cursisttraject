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
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppInitializer.class, AppConfig.class, HibernateConfiguration.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@WebAppConfiguration
public class PersoonsrolMateriaalServiceImplTest {
    
    @Autowired
    private PersoonsrolHasMateriaalService service; 
    @Autowired
    private PersoonsrolService persoonsrolService;
    @Autowired 
    private MateriaalService materiaalService;
    @Autowired
    private PersoonService persoonService;     
    @Autowired
    private RolService rolService;   
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

    @Test
    @Transactional
    public void testCreate() {
        service.create(hasMat);
        service.flushSession();
        PersoonsrolHasMateriaal result = service.read(hasMat.getId());
        assertNotNull("result must not be null", result);
      assertEquals("Persoonsrol must be equal", hasMat.getPersoonsrol().getPersoon(), result.getPersoonsrol().getPersoon());
        assertEquals("Materiaal must be equal", hasMat.getMateriaal(), result.getMateriaal());
        //assertEquals("All fields must be equal", hasMat, result);
        
    }

    @Test
    @Transactional
    public void testUpdate() {
        service.create(hasMat);
        PersoonsrolHasMateriaalId id = hasMat.getId();
        service.flushSession();
        PersoonsrolHasMateriaal result = service.read(id);
        result.setCursistBezit('N');
        service.update(result);
        service.flushSession();
        
        hasMat = service.read(id);
        assertNotNull("result must not be null", hasMat);
        assertTrue("New CursistBezit must be N", hasMat.getCursistBezit() == ('N')); 
    }

    @Test
    @Transactional
    public void testRead() {
        service.create(hasMat);
        PersoonsrolHasMateriaalId id = hasMat.getId();
        service.flushSession();
        PersoonsrolHasMateriaal result = service.read(id);
        assertNotNull("result must not be null", result);
        
      assertEquals("Persoonsrol must be equal", hasMat.getPersoonsrol().getPersoon(), result.getPersoonsrol().getPersoon());
        assertEquals("Materiaal must be equal", hasMat.getMateriaal(), result.getMateriaal());
//        assertEquals("All fields must be equal", hasMat, result);
    }

    @Test
    @Transactional
    public void testDelete() {
        service.create(hasMat);
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("PersoonsrolHasMateriaal not found");
        
        PersoonsrolHasMateriaalId id = hasMat.getId();
        service.delete(hasMat);

        PersoonsrolHasMateriaal result = service.read(id);
        assertNull("Result is null, object has been deleted", result);
    }

    @Test
    @Transactional
    public void testGetAll() {
        service.create(hasMat);
        service.flushSession();
        List<PersoonsrolHasMateriaal> resultList = service.getAll();
        assertNotNull("resultList must not be null", resultList);
        PersoonsrolHasMateriaal result = resultList.get(resultList.size()-1);
        assertEquals("result and hasMat must be equal", hasMat.getId().getMateriaalId(), result.getId().getMateriaalId());
        //assertTrue("hasMat must be in the resultList", resultList.contains(hasMat));
    }   
}
