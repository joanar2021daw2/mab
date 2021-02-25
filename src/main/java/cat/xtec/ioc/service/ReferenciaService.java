package cat.xtec.ioc.service;

import cat.xtec.ioc.domain.Referencia;
import java.util.List;

/**
 *
 * @author JoseAndrade
 */
public interface ReferenciaService {
        
    List<Referencia> getAllPReferencies();
    
    List<Referencia> getReferenciaBySeccio(String seccio);
    
    Referencia getreferenciaByName(String referencia);
    
    void addReferencia(Referencia referencia);
    
    public void updateReferencia(Referencia referencia);
    
    void deleteReferencia(Referencia referencia);
    
    
}
