package cat.xtec.ioc.service;

import cat.xtec.ioc.domain.Resultat;
import cat.xtec.ioc.domain.User;
import java.util.List;

/**
 *
 * @author JoseAndrade
 */
public interface UserService {

    User getUserById(Integer id);

    User getUserByNom(String nom);

    List<User> getAllUsers();

    List<User> getUserBySeccio(String seccio);

    User getUserByNumOperari(int numOperari);

    void createUser(User user);

    void updateUser(User user);

    public void remove(User user);

    public User addResultat(Resultat resultat, Integer numOperari);
    
}
