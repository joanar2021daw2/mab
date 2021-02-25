package cat.xtec.ioc.service;

import cat.xtec.ioc.domain.Resultat;
import java.util.List;
import java.util.Set;

/**
 *
 * @author JoseAndrade
 */
public interface ResultatService {

    void createResultat(Resultat resultat);

    Resultat getResultatById(Integer idReferencia);

    List<Resultat> getAllResultats();

    void removeResultat(Resultat resultat);

    void updateResultat(Resultat resultat);

    Set<Resultat> getAllResultats(int numOperari);
    
    Set<Resultat> getResultatsByReferenceAndUser(Integer numOperari, String referencia);

}
