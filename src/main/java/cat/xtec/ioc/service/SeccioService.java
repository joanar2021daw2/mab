package cat.xtec.ioc.service;

import cat.xtec.ioc.domain.Seccio;
import java.util.List;

/**
 *
 * @author JoseAndrade
 */
public interface SeccioService {
        
    List<Seccio> getAllSeccions();
    
    Seccio getSeccioByName(String nomSeccio);
    
    Seccio getSeccioById(int idSeccio);
    
    void addSeccio(Seccio seccio);
    
    public void updateSeccio(Seccio seccio);
    
    void deleteSeccio(Seccio seccio);
}
