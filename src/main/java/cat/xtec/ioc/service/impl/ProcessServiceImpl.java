package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.repository.ProcessRepository;
import cat.xtec.ioc.service.ProcessService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JoseAndrade
 */
@Service
public class ProcessServiceImpl implements ProcessService{

    @Autowired
    private ProcessRepository processRepository;
    
    @Override
    public List<Process> getAllProcess() {
        return processRepository.getAllProcess();
    }

    @Override
    public List<Process> getProcessBySeccio(String seccio) {
        return (List<Process>) processRepository.getProcessBySeccio(seccio);
    }

    @Override
    public List<Process> getProcessByReferenia(String referencia) {
        return (List<Process>) processRepository.getProcessByReferenia(referencia);
    }

    @Override
    public Process getProcessById(int idProcess) {
        return processRepository.getProcessById(idProcess);
    }

    @Override
    public void addProcess(Process proces) {
        processRepository.addProcess(proces);
    }

    @Override
    public void updateProcess(Process process) {
        processRepository.updateProcess(process);
    }

    @Override
    public void deleteProcess(Process proces) {
        processRepository.deleteProcess(proces);
    }
    
}
