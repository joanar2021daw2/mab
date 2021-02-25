package cat.xtec.ioc.repository;

import cat.xtec.ioc.domain.Seccio;
import java.util.List;

/**
 *
 * @author JoseAndrade
 */
public interface SeccioRepository {

    List<Seccio> getAllSeccions();

    Seccio getProcessByName(String nomSeccio);

    Seccio getSeccioById(int idSeccio);

    void addSeccio(Seccio seccio);

    public void updateSeccio(Seccio seccio);

    void deleteSeccio(Seccio seccio);
}
