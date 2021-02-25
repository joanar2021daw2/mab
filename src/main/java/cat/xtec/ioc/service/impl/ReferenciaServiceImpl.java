package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.domain.Referencia;
import cat.xtec.ioc.repository.ReferenciaRepository;
import cat.xtec.ioc.service.ReferenciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JoseAndrade
 */
@Service
public class ReferenciaServiceImpl implements ReferenciaService{
    
    @Autowired
    private ReferenciaRepository referenciaRepository;

    @Override
    public List<Referencia> getAllPReferencies() {
        return (List<Referencia>)referenciaRepository.getAllReferencies();
    }

    @Override
    public List<Referencia> getReferenciaBySeccio(String seccio) {
        return (List<Referencia>) referenciaRepository.getReferenciaBySeccio(seccio);
    }

    @Override
    public Referencia getreferenciaByName(String referencia) {
        return referenciaRepository.getreferenciaByName(referencia);
    }

    @Override
    public void addReferencia(Referencia referencia) {
        referenciaRepository.addReferencia(referencia);
    }

    @Override
    public void updateReferencia(Referencia referencia) {
        referenciaRepository.updateReferencia(referencia);
    }

    @Override
    public void deleteReferencia(Referencia referencia) {
        referenciaRepository.deleteReferencia(referencia);
    }
    
}
