package cat.xtec.ioc.repository;

import java.util.List;

/**
 *
 * @author JoseAndrade
 */
public interface ProcessRepository {

    List<Process> getAllProcess();

    List<Process> getProcessBySeccio(String seccio);

    List<Process> getProcessByReferenia(String referencia);

    Process getProcessById(int idProcess);

    void addProcess(Process proces);

    public void updateProcess(Process process);

    void deleteProcess(Process proces);
}
