/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.resultat;

import cat.xtec.ioc.config.EmbeddedDatabaseTestConfig;
import cat.xtec.ioc.domain.Referencia;
import cat.xtec.ioc.domain.Resultat;
import cat.xtec.ioc.domain.User;
import cat.xtec.ioc.repository.ResultatRepository;
import cat.xtec.ioc.repository.UserRepository;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
//@Rollback(false)
public class ResultatDAOTest {

    @Autowired
    private ResultatRepository repositoryDAO;

    @Autowired
    private UserRepository userDAO;

    @Test
    @Transactional
    public void saveResult() {

        //Arrange
        User user = new User();
        user.setNumOperari(230);
        user.setActive(true);
        user.setNom("jose");
        user.setCognom1("Andrade");
        user.setCognom2("Arador");
        user.setPassword("password");
        userDAO.createUser(user);
        

        Set<Resultat> resultats = new HashSet<>();
        Resultat res = new Resultat();
        Referencia ref = new Referencia();

        res.setCreatedOn(new Timestamp(new Date().getTime()));
        res.setTempsPassos("{\"1\":\"68\",\"2\":\"27\"}");
        res.setTempsTotal(95);

        //Afegir set de resultats
        resultats.add(res);
        user.setResultats(resultats);

        //Act
        assertNull(res.getIdResultat());
        repositoryDAO.createResultat(res);
        assertNotNull(res.getIdResultat());

        res.setIdResultat(77);

        //Assert
        assertTrue(res.getIdResultat() == 77);

    }

}
