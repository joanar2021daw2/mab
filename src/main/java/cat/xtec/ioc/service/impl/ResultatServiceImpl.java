package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.domain.Resultat;
import cat.xtec.ioc.domain.User;
import cat.xtec.ioc.repository.ReferenciaRepository;
import cat.xtec.ioc.repository.ResultatRepository;
import cat.xtec.ioc.repository.UserRepository;
import cat.xtec.ioc.service.ResultatService;
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
public class ResultatServiceImpl implements ResultatService {

    @Autowired
    private ResultatRepository resultatRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void createResultat(Resultat resultat) {
        resultatRepository.createResultat(resultat);
    }

    @Override
    public Resultat getResultatById(Integer idReferencia) {
        return resultatRepository.getResultatById(idReferencia);
    }

    @Override
    public List<Resultat> getAllResultats() {
        return (List<Resultat>) resultatRepository.getAllResultats();
    }

    @Override
    public void removeResultat(Resultat resultat) {
        resultatRepository.removeResultat(resultat);
    }

    @Override
    public void updateResultat(Resultat resultat) {
        resultatRepository.updateResultat(resultat);
    }

    @Override
    public Set<Resultat> getAllResultats(int numOperari) {
        User user = userRepository.getUserByNumOperari(numOperari);
        return user.getResultats();
    }
    
    @Override
    public Set<Resultat> getResultatsByReferenceAndUser(Integer numOperari, String referencia){
        User user = userRepository.getUserByNumOperari(numOperari);
        
        Set<Resultat> resultatsUsuari = user.getResultats();
        
        
        
        return resultatsUsuari;
    }

  

}
