package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.repository.ProcessRepository;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JoseAndrade
 */
@Transactional
@Repository("processRepositoryImpl")
public class ProcessRepositoryImpl implements ProcessRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Process> getAllProcess() {
        return (List<Process>) getSession().createCriteria(Process.class).list();
    }

    @Override
    public List<Process> getProcessBySeccio(String seccio) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("seccio", seccio));
        return (List<Process>) criteria.list();
    }

    @Override
    public List<Process> getProcessByReferenia(String referencia) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("referencia", referencia));
        return (List<Process>) criteria.list();
    }

    @Override
    public Process getProcessById(int idProcess) {
        return getSession().get(Process.class, idProcess);
    }

    @Override
    public void addProcess(Process process) {
        getSession().saveOrUpdate(process);
    }

    @Override
    public void updateProcess(Process process) {
        getSession().saveOrUpdate(process);

    }

    @Override
    public void deleteProcess(Process process) {
        getSession().remove(process);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Criteria createEntityCriteria() {
        return getSession().createCriteria(Process.class);
    }
}
