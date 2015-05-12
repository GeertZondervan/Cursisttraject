package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Persoon;
import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.PersoonsrolHasTraject;
import edu.rsvier.springmvc.model.PersoonsrolHasTrajectId;
import edu.rsvier.springmvc.model.Rol;
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
public class PersoonsrolHasTrajectServiceImplTest {

    @Autowired
    private PersoonsrolHasTrajectService service;
    @Autowired
    private PersoonsrolService persoonsrolService;
    @Autowired
    private TrajectService trajectService;
    @Autowired
    private PersoonService persoonService;
    @Autowired
    private RolService rolService;
    private PersoonsrolHasTraject hasTraject;

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

        Traject traject = PojoGenerator.getTraject();
        trajectService.create(traject);

        hasTraject = PojoGenerator.getPersoonsrolHasTraject(traject, persoonsrol);
    }

    @After
    public void tearDown() {
    }

    @Test
    @Transactional
    public void testCreate() {
        service.create(hasTraject);
        service.flushSession();
        PersoonsrolHasTraject result = service.read(hasTraject.getId());
        assertNotNull("result must not be null", result);
        System.out.println(hasTraject.getPersoonsrol() + "DD FF FF FF F FF F");
        System.out.println(result.getPersoonsrol() + " DD D DD D D  D D");
        assertEquals("0 must be equal", hasTraject, result);
    }

    @Test
    @Transactional
    public void testUpdate() {
        service.create(hasTraject);
        PersoonsrolHasTrajectId id = hasTraject.getId();
        service.flushSession();
        PersoonsrolHasTraject result = service.read(id);
        result.setSuccesvolAfgerond('N');
        service.update(result);
        service.flushSession();

        hasTraject = service.read(id);
        assertNotNull("result must not be null", hasTraject);
        assertTrue("New SuccesvolAfgerond must be N", hasTraject.getSuccesvolAfgerond() == ('N'));
    }

    @Test
    @Transactional
    public void testRead() {
        service.create(hasTraject);
        PersoonsrolHasTrajectId id = hasTraject.getId();
        service.flushSession();
        PersoonsrolHasTraject result = service.read(id);
        assertNotNull("result must not be null", result);
        assertEquals("0 must be equal", hasTraject, result);
}

    @Test
    @Transactional
    public void testDelete() {
        service.create(hasTraject);
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("PersoonsrolHasTraject not found");

        PersoonsrolHasTrajectId id = hasTraject.getId();
        service.delete(hasTraject);

        PersoonsrolHasTraject result = service.read(id);
        assertNull("Result is null, object has been deleted", result);
    }

    @Test
    @Transactional
    public void testGetAll() {
        service.create(hasTraject);
        service.flushSession();
        List<PersoonsrolHasTraject> resultList = service.getAll();
        assertNotNull("resultList must not be null", resultList);
        PersoonsrolHasTraject result = resultList.get(resultList.size() - 1);
        assertEquals("result and hasTraject must be equal", hasTraject.getId().getTrajectId(), result.getId().getTrajectId());
        assertTrue("hasTraject must be in the resultList", resultList.contains(hasTraject));
    }

}
