package cat.xtec.ioc.repository;

import cat.xtec.ioc.domain.Resultat;
import java.util.List;
import java.util.Set;

/**
 *
 * @author JoseAndrade
 */
public interface ResultatRepository {
    
    void createResultat(Resultat resultat);

    List<Resultat> getResultatsByUsuari(Integer numOperari);

    Resultat getResultatById(Integer idReferencia);

    List<Resultat> getAllResultats();

    public void removeResultat(Resultat resultat);

    public void updateResultat(Resultat resultat);
    
}
