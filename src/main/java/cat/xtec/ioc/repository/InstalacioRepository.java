package cat.xtec.ioc.repository;

import cat.xtec.ioc.domain.Instalacio;
import java.util.List;

/**
 *
 * @author JoseAndrade
 */
public interface InstalacioRepository {

    Instalacio getInstalacioById(Integer id);

    List<Instalacio> getAllInstalacions();

    List<Instalacio> getInstalacionsBySeccio(Integer idSeccio);

    void addInstalacio(Instalacio instalacio);

    public void updateInstalacio(Instalacio instalacio);
}
