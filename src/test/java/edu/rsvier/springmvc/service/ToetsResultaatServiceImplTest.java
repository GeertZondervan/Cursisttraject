package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Module;
import edu.rsvier.springmvc.model.Persoon;
import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.Rol;
import edu.rsvier.springmvc.model.Toets;
import edu.rsvier.springmvc.model.ToetsResultaat;
import edu.rsvier.springmvc.model.ToetsResultaatId;
import edu.rsvier.springmvc.model.Traject;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
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
public class ToetsResultaatServiceImplTest {

    @Autowired
    private ToetsResultaatService service;
    @Autowired
    private ToetsService toetsService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private TrajectService trajectService;
    @Autowired
    private PersoonsrolService persoonsrolService;
    @Autowired
    private PersoonService persoonService;
    @Autowired
    private RolService rolService;
    private ToetsResultaat toetsResultaat;
    
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() {
        Traject traject = PojoGenerator.getTraject();
        trajectService.create(traject);

        Module module = PojoGenerator.getModule(traject);
        moduleService.create(module);

        Toets toets = PojoGenerator.getToets(module);
        toetsService.create(toets);

        Persoon persoon = PojoGenerator.getPersoon();
        persoonService.create(persoon);

        Rol rol = PojoGenerator.getRol();
        rolService.create(rol);

        Persoonsrol persoonsrol = PojoGenerator.getPersoonsrol(persoon, rol);
        persoonsrolService.create(persoonsrol);

        toetsResultaat = PojoGenerator.getToetsResultaat(toets, persoonsrol);
        service.create(toetsResultaat);

    }

    @After
    public void tearDown() {
    }

    @Test
    @Transactional
    public void testCreate() {
        System.out.println("///////" + toetsResultaat);
                
        service.flushSession();
        System.out.println("////////" + toetsResultaat.getId());
        ToetsResultaat result = service.read(toetsResultaat.getId());
        System.out.println("///////" + result);
        assertNotNull("toetsResultaat must not be null", toetsResultaat);
        assertNotNull("result must not be null", result);
        assertEquals("toetsResultaat, all fields must be equal", toetsResultaat, result);
    }
//
//    @Test
//    @Transactional
//    public void testUpdate() {
//        ToetsResultaatId toetsResultaatId = toetsResultaat.getId();
//        ToetsResultaat result = (ToetsResultaat) service.read(toetsResultaatId);
//        result.setResultaat(10f);
//        service.update(result);
//        service.flushSession();
//
//        toetsResultaat = service.read(toetsResultaatId);
//
//        assertNotNull("result must not be null", toetsResultaat);
//        assertTrue("New Resultaat must be 10f", toetsResultaat.getResultaat() == (10.0));
//    }

//    @Test
//    @Transactional
//    public void testRead_id() {
//        service.create(toetsResultaat);
//        service.flushSession();
//
//        ToetsResultaat result = (ToetsResultaat) service.read(toetsResultaat.getId());
//        
//        assertNotNull("toetsResultaat must not be null", toetsResultaat);
//        assertNotNull("result must not be null", result);
//        assertEquals("toetsResultaat, all fields must be equal", toetsResultaat, result);
//    }

//    @Test
//    @Transactional
//    public void testDelete() {
//        expectedEx.expect(NullPointerException.class);
//        expectedEx.expectMessage("ToetsResultaat not found");
//        ToetsResultaatId toetsResultaatId = toetsResultaat.getId();
//        service.delete(toetsResultaat);
//
//        ToetsResultaat result = service.read(toetsResultaatId);
//        assertNull("Result is null, object has been deleted", result);
//
//    }
//
//    @Test
//    @Transactional
//    public void testGetAll() {
//        List<ToetsResultaat> resultList = service.getAll();
//        assertNotNull("resultList must not be null", resultList);
//        assertTrue("toetsResultaat must be in the resultList", resultList.contains(toetsResultaat));
//        //assertTrue("toetsResultaat2 must be in the resultList", resultList.contains(toetsResultaat2));
//    }

}
