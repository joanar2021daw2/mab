package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.domain.Resultat;
import cat.xtec.ioc.domain.User;
import cat.xtec.ioc.repository.UserRepository;
import cat.xtec.ioc.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JoseAndrade
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.getAllUsers();
    }

    @Override
    public User getUserByNom(String nom) {
        return userRepository.getUserByNom(nom);
    }

    @Override
    public User getUserByNumOperari(int numOperari) {
        return userRepository.getUserByNumOperari(numOperari);
    }

    @Override
    public List<User> getUserBySeccio(String seccio) {
        return (List<User>) userRepository.getUserBySeccio(seccio);
    }

    @Override
    public void createUser(User user) {
        User usuariRepetit = userRepository.getUserByNumOperari(user.getNumOperari());
        if(usuariRepetit == null){
            userRepository.createUser(user);
        }else{
            //missatge numero operari ja existeix
        }
        
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public void remove(User user) {
        userRepository.removeUser(user);
    }

    public User addResultat(Resultat resultat, Integer numOperari) {
        User user = userRepository.getUserByNumOperari(numOperari);
        
        Set<Resultat> resultatsUsuari = user.getResultats();
        resultatsUsuari = addResultatToCollection(resultat, resultatsUsuari);
        user.setResultats(resultatsUsuari);
        //Creem o actualitzem l'usuari
        userRepository.createUser(user);
        
        return user;        
    }
    
    //Afegir resultat al set de resultats
    private Set<Resultat> addResultatToCollection(Resultat resultat, Set<Resultat> resultats){
        if(resultats != null){
            resultats.add(resultat);
        }else{
            resultats = new HashSet<Resultat>();
            resultats.add(resultat);
        }
        return resultats;
    }

}
