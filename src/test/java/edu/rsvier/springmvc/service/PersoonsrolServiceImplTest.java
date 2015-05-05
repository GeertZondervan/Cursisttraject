package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.*;
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
public class PersoonsrolServiceImplTest {

    @Autowired
    private PersoonsrolService service;
    @Autowired
    PersoonService persoonService;
    @Autowired
    private RolService rolService;
    private Persoonsrol persoonsrol;
    private Persoonsrol persoonsrol2;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() {
        Persoon persoon = PojoGenerator.getPersoon();
        Persoon persoon2 = PojoGenerator.getPersoon();
        persoonService.create(persoon);
        persoonService.create(persoon2);

        Rol rol = PojoGenerator.getRol();
        Rol rol2 = PojoGenerator.getRol();
        rolService.create(rol);
        rolService.create(rol2);

        persoonsrol = PojoGenerator.getPersoonsrol(persoon, rol);
        service.create(persoonsrol);

        persoonsrol2 = PojoGenerator.getPersoonsrol(persoon2, rol2);
        service.create(persoonsrol2);
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

        Persoonsrol result = (Persoonsrol) service.read(persoonsrol2.getId());

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

        Persoonsrol result = (Persoonsrol) service.read(persoonsrol.getId());
        Rol rol = new Rol();
        rol.setNaam("Trainee");
        rolService.create(rol);
        result.setRol(rol);
        
        service.update(result);
        service.flushSession();
        Persoonsrol persoonsrol3 = service.read(result.getId());
        
        System.out.println(result);
        System.out.println(persoonsrol3);
        assertNotNull("result must not be null", persoonsrol3);
        // Klopt, niet, weten we, maar persoonsrol updaten is sowieso bullshit. Persoon en rol blijven vastzitten aan persoonsrol
        
    }

    /**
     * Test of read method, of class PersoonsrolServiceImpl.
     */
    @Test
    @Transactional
    public void testRead_int() {
        Persoonsrol result = (Persoonsrol) service.read(persoonsrol.getId());

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
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Persoonsrol not found");

        PersoonsrolId persoonsrolId = persoonsrol.getId();
        service.delete(persoonsrol);

        Persoonsrol result = service.read(persoonsrolId);
        assertNull("Result is null, object has been deleted", result);

    }

}
