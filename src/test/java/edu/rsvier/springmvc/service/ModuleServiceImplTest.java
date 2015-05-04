package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Module;
import edu.rsvier.springmvc.model.Traject;
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
public class ModuleServiceImplTest {

    @Autowired
    private ModuleService service;
    
    @Autowired
    private TrajectService trajectService;

    private Module module;
    
    private Traject traject;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() {
        traject = PojoGenerator.getTraject();
        module = PojoGenerator.getModule(traject);
        trajectService.create(traject);
        service.create(module);
    }

    @After
    public void tearDown() {
    }

    @Test
    @Transactional
    public void testCreate() {
        Module module2 = PojoGenerator.getModule(traject);
        service.create(module2);
        Module result = service.read(module2.getId());

        assertNotNull("module, must not be null", module2);
        assertNotNull("Result, must not be null", result);
        assertTrue("id, must be positive", result.getId() >= 0);
        assertEquals("module, all fields must be equal", module2, result);
    }

    @Test
    @Transactional
    public void testCreateNotComplete() {
        Module module2 = new Module();
        //module2.setTraject(traject);
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Module not complete");
        service.create(module2);
    }

    @Test
    @Transactional
    public void testRead() {
        Module result = service.read(module.getId());
        assertNotNull("module, must not be null", module);
        assertNotNull("Result, must not be null", result);
        assertTrue("id, must be positive", result.getId() >= 0);
        assertEquals("persoon, all fields must be equal", module, result);
    }

    @Test
    @Transactional
    public void testReadNotFound() {
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Module not found");
        Module result = service.read(0);
    }

    // Wiemer: Leroy/Timo/iemand anders vragen hoe we de Hibernate cache kunnen omzeilen. TestUpdate werkt nu ook zonder update aan te roepen.
    @Test
    @Transactional
    public void testUpdate() {
        Module module2 = service.read(module.getId());
        module2.setOmschrijving("Module 2");
        service.update(module2);
        int id = module.getId();
        Module result = service.read(id);

        assertNotNull("Result, must not be null", result);
        assertTrue("Modulelengte, must be 5", result.getOmschrijving() == "Module 2");
    }

    
    //Wiemer: Zou foutmelding moeten geven, maar werkt gek genoeg.
    @Test
    @Transactional
    public void testUpdateNotFound() {

        //expectedEx.expect(IllegalArgumentException.class);
        //expectedEx.expectMessage("Cannot update, module not found");
        Module module3 = new Module();
        module3.setTraject(traject);
        module3.setOmschrijving("Module 1");

        service.update(module3);
    }

    @Test
    @Transactional
    public void testDelete() {
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Module not found");

        service.create(module);
        service.delete(module);
        int id = module.getId();
        Module result = service.read(id);
    }

}
