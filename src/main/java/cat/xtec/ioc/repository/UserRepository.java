package cat.xtec.ioc.repository;

import cat.xtec.ioc.domain.User;
import java.util.List;

/**
 *
 * @author JoseAndrade
 */
public interface UserRepository {
    
    User getUserById(Integer id);

    List<User> getAllUsers();

    List<User> getUserBySeccio(String seccio);

    User getUserByNumOperari(Integer numOperari);

    User getUserByNom(String nom);

    void createUser(User user);

    public void removeUser(User user);

    public void updateUser(User user);

}
