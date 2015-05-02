package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.configuration.AppConfig;
import edu.rsvier.springmvc.configuration.AppInitializer;
import edu.rsvier.springmvc.configuration.HibernateConfiguration;
import edu.rsvier.springmvc.model.Module;
import edu.rsvier.springmvc.model.Persoon;
import edu.rsvier.springmvc.model.Persoonsrol;
import edu.rsvier.springmvc.model.PersoonsrolId;
import edu.rsvier.springmvc.model.Rol;
import edu.rsvier.springmvc.model.Toets;
import edu.rsvier.springmvc.model.ToetsResultaat;
import edu.rsvier.springmvc.model.ToetsResultaatId;
import edu.rsvier.springmvc.model.Traject;
import java.util.Date;
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
    private ToetsResultaat toetsResultaat2;
    private ToetsResultaatId toetsResultaatId;

    @Before
    public void setUp() {
      
        Traject traject = new Traject();
        traject.setNaam("Java Developer");
        traject.setOmschrijving("Opleiding tot Java Developer");
        traject.setStartdatum(new Date());
        trajectService.create(traject);
        
        Module module = new Module();
        module.setTraject(traject);
        moduleService.create(module);
        
        Toets toets = new Toets();
        toets.setNaam("Java toets 1");
        toets.setOmschrijving("Eerste toets");
        toets.setModule(module);
        toets.setStof("Boek 1");
        toets.setStatus("Klaar");
        toets.setMinimumResultaat(5.5f);
        toetsService.create(toets);

        Persoon persoon = new Persoon();
        persoon.setVoornaam("Karel");
        persoon.setAchternaam("Appel");
        persoonService.create(persoon);
        
        Rol rol = new Rol();
        rol.setNaam("Cursist");
        rolService.create(rol);
        
        PersoonsrolId persoonsrolId = new PersoonsrolId();
        persoonsrolId.setPersoonId(persoon.getId());
        persoonsrolId.setRolId(rol.getId());
        persoonsrolId.setBegindatum(new Date());
        
        Persoonsrol persoonsrol = new Persoonsrol();
        persoonsrol.setPersoon(persoon);
        persoonsrol.setRol(rol);
        persoonsrol.setId(persoonsrolId);
        persoonsrolService.create(persoonsrol);
        
        toetsResultaatId = new ToetsResultaatId();
        toetsResultaatId.setPersoonsrolPersoonId(persoonsrolId.getPersoonId());
        toetsResultaatId.setPersoonsrolRolId(persoonsrolId.getRolId());
        toetsResultaatId.setPersoonsrolBegindatum(persoonsrolId.getBegindatum());
        toetsResultaatId.setToetsId(toets.getId());
        
        toetsResultaat = new ToetsResultaat();
        toetsResultaat.setResultaat(8.8f);
        toetsResultaat.setDatum(new Date());
        toetsResultaat.setToets(toets);
        toetsResultaat.setPersoonsrol(persoonsrol);
        toetsResultaat.setId(toetsResultaatId);
        service.create(toetsResultaat);

        ToetsResultaatId toetsResultaatId2 = new ToetsResultaatId();
        toetsResultaatId2.setPersoonsrolPersoonId(persoonsrolId.getPersoonId());
        toetsResultaatId2.setPersoonsrolRolId(persoonsrolId.getRolId());
        toetsResultaatId2.setPersoonsrolBegindatum(persoonsrolId.getBegindatum());
        toetsResultaatId2.setToetsId(toets.getId());
        
        toetsResultaat2 = new ToetsResultaat();
        toetsResultaat2.setResultaat(5.8f);
        toetsResultaat2.setDatum(new Date());
        toetsResultaat2.setToets(toets);
        toetsResultaat2.setPersoonsrol(persoonsrol);
        toetsResultaat2.setId(toetsResultaatId2);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ToetsResultaatServiceImpl.
     */
    @Test
    @Transactional
    public void testCreate() {
        System.out.println("creating toetsResultaat");
        //service.create(toetsResultaat);
        
        ToetsResultaat result = (ToetsResultaat) service.read(toetsResultaat.getId());
        System.out.println(toetsResultaat.getId() + " HHHAHHS AFSF G");
        System.out.println(result + " XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        assertNotNull("toetsResultaat must not be null", toetsResultaat);
        assertNotNull("result must not be null", result);

        assertEquals("toetsResultaat, all fields must be equal", toetsResultaat, result);
    }

    /**
     * Test of update method, of class ToetsResultaatServiceImpl.
     */
    @Test
    @Transactional
    public void testUpdate() {
        ToetsResultaatId toetsResultaatId = toetsResultaat.getId();
        ToetsResultaat result = (ToetsResultaat) service.read(toetsResultaatId);
        result.setResultaat(10f);
        service.update(result);

        toetsResultaat = service.read(toetsResultaatId);

        assertNotNull("result must not be null", toetsResultaat);

        assertEquals("toetsResultaat, all fields must be equal", toetsResultaat, result);
    }

    /**
     * Test of read method, of class ToetsResultaatServiceImpl.
     */
    @Test
    @Transactional
    public void testRead_id() {
        System.out.println("creating toetsResultaat");
        service.create(toetsResultaat);

        ToetsResultaat result = (ToetsResultaat) service.read(toetsResultaat.getId());
        ToetsResultaatId toetsResultaatId = result.getId();

        assertNotNull("toetsResultaat must not be null", toetsResultaat);
        assertNotNull("result must not be null", result);

        assertEquals("toetsResultaat, all fields must be equal", toetsResultaat, result);
    }



    /**
     * Test of delete method, of class ToetsResultaatServiceImpl.
     */
    @Test
    @Transactional
    public void testDelete() {
        service.create(toetsResultaat);
        ToetsResultaatId toetsResultaatId = toetsResultaat.getId();
        service.delete(toetsResultaat);

        ToetsResultaat result = service.read(toetsResultaatId);
        assertNull("Result is null, object has been deleted", result);

    }

    /**
     * Test of getAll method, of class ToetsResultaatServiceImpl.
     */
    @Test
    @Transactional
    public void testGetAll() {
        System.out.println("getAll");
        //service.create(toetsResultaat);

        List<ToetsResultaat> resultList = service.getAll();
        assertNotNull("resultList must not be null", resultList);

        assertTrue("toetsResultaat must be in the resultList", resultList.contains(toetsResultaat));
        //assertTrue("toetsResultaat2 must be in the resultList", resultList.contains(toetsResultaat2));

    }

}
