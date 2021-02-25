package cat.xtec.ioc.user;

import cat.xtec.ioc.config.EmbeddedDatabaseTestConfig;
import cat.xtec.ioc.domain.Resultat;
import cat.xtec.ioc.domain.User;
import cat.xtec.ioc.repository.ResultatRepository;
import cat.xtec.ioc.repository.UserRepository;
import cat.xtec.ioc.service.UserService;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JoseAndrade
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmbeddedDatabaseTestConfig.class}) //Canviar per EmbededDatab...
public class UserDAOTest {

    @Autowired
    private UserRepository userDAO;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ResultatRepository resultatDAO;

    @Test
    @Transactional
    public void saveUser() {
        //Arrange
        User user = new User();
        user.setNumOperari(230);
        user.setActive(true);
        user.setNom("jose");
        user.setCognom1("Andrade");
        user.setCognom2("Arador");
        user.setPassword("password");
        user.setResultats(new HashSet<Resultat>());

        User user2 = new User();
        user2.setNumOperari(148);
        user2.setActive(false);
        user2.setNom("Cristian");
        user2.setCognom1("Hungridor");
        user2.setCognom2("Toma");
        user2.setPassword("password2");
        user2.setResultats(new HashSet<Resultat>());

        //Act
        assertNull(user.getUserId());// Valor auto-generat , un cop Hibernate persisteixi l'objecte ho tindrem
        userDAO.createUser(user);
        assertNotNull(user.getUserId()); //Aqui ja estarà generat
        user.setPassword("new-password");//Actualitzar password

        userDAO.createUser(user2);

        //Assert
        User userFromDb = userDAO.getUserByNumOperari(user.getNumOperari());
        assertEquals(user.getUserId(), userFromDb.getUserId());
        assertEquals("new-password", userFromDb.getPassword());

        //Total usuaris
        List<User> usuarisAll = userDAO.getAllUsers();
        assertTrue(usuarisAll.size() == 2);

    }

    @Test
    @Transactional
    public void saveResultat() {

        //Arrange
        User user = new User();
        user.setNumOperari(230);
        user.setActive(true);
        user.setNom("jose");
        user.setCognom1("Andrade");
        user.setCognom2("Arador");
        user.setPassword("password");
        user.setResultats(new HashSet<Resultat>());

        Resultat res = new Resultat();
        res.setCreatedOn(new Timestamp(new Date().getTime()));
        res.setTempsPassos("{\"1\":\"68\",\"2\":\"27\"}");
        res.setTempsTotal(168);
        
        resultatDAO.createResultat(res);
        assertNotNull(res.getIdResultat());
        
        //Act
        userDAO.createUser(user);
        assertNotNull(user.getUserId());
 
        user = userService.addResultat(res, 230);
        
        //Assert
        assertFalse( user.getResultats().isEmpty() );
    }

}
