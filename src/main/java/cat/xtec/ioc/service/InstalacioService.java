package cat.xtec.ioc.service;

import cat.xtec.ioc.domain.Instalacio;
import java.util.List;

/**
 *
 * @author JoseAndrade
 */
public interface InstalacioService {
    
    Instalacio getInstalacioById(int id);
    
    List<Instalacio> getAllInstalacions();
    
    List<Instalacio> getInstalacionsBySeccio(int idSeccio);
    
    void addInstalacio (Instalacio instalacio);
    
    public void updateInstalacio (Instalacio instalacio);
     
}
