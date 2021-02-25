package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.domain.Seccio;
import cat.xtec.ioc.repository.SeccioRepository;
import cat.xtec.ioc.service.SeccioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JoseAndrade
 */
@Service
public class SeccioServiceImpl implements SeccioService{

    @Autowired
    private SeccioRepository seccioRepository;
    
    @Override
    public List<Seccio> getAllSeccions() {
        return (List<Seccio>) seccioRepository.getAllSeccions();
    }

    @Override
    public Seccio getSeccioByName(String nomSeccio) {
        return seccioRepository.getProcessByName(nomSeccio);
     }

    @Override
    public Seccio getSeccioById(int idSeccio) {
        return (Seccio) seccioRepository.getSeccioById(idSeccio);
    }

    @Override
    public void addSeccio(Seccio seccio) {
        seccioRepository.addSeccio(seccio);
    }

    @Override
    public void updateSeccio(Seccio seccio) {
        seccioRepository.updateSeccio(seccio);
    }

    @Override
    public void deleteSeccio(Seccio seccio) {
        seccioRepository.deleteSeccio(seccio);
    }
    
}
