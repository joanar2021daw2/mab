package cat.xtec.ioc.seccio;

import cat.xtec.ioc.config.EmbeddedDatabaseTestConfig;
import cat.xtec.ioc.config.HibernateMysqlConfiguration;
import cat.xtec.ioc.domain.Seccio;
import cat.xtec.ioc.repository.SeccioRepository;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JoseAndrade
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmbeddedDatabaseTestConfig.class})
public class SeccioDAOTest {
    

    @Autowired
    private SeccioRepository seccioDAO;

    @Test
    @Transactional
    public void saveSeccio() {
        //Arrange
        Seccio seccio = new Seccio();
        seccio.setNom("soldadura_BU1");
        seccio.setTipusProduccio("soldadura");

        assertNull(seccio.getIdSeccio());

        //Act 
        seccioDAO.addSeccio(seccio);

        //Assert
        assertNotNull(seccio.getIdSeccio());

    }

    @Test
    @Transactional
    public void getSeccioByName() {
        //arrange
        Seccio seccio = new Seccio();
        seccio.setNom("soldadura_BU1");
        seccio.setTipusProduccio("soldadura");

        //Act 
        seccioDAO.addSeccio(seccio);

        Seccio seccioFromBd = seccioDAO.getProcessByName("soldadura_BU1");
        assertEquals(seccio.getTipusProduccio(), seccioFromBd.getTipusProduccio());
    }

    @Test
    @Transactional
    public void GetAll() {
        //arrange
        Seccio seccio = new Seccio();
        seccio.setNom("soldadura_BU1");
        seccio.setTipusProduccio("soldadura");

        Seccio seccio2 = new Seccio();
        seccio2.setNom("soldadura_BU1");
        seccio2.setTipusProduccio("soldadura");

        Seccio seccio3 = new Seccio();
        seccio3.setNom("soldadura_BU1");
        seccio3.setTipusProduccio("soldadura");

        //Act
        seccioDAO.addSeccio(seccio);
        seccioDAO.addSeccio(seccio2);
        seccioDAO.addSeccio(seccio3);
        
        List allSeccions = seccioDAO.getAllSeccions();
        
        //Assert
        assertTrue(allSeccions.size() == 3);
    }
}
