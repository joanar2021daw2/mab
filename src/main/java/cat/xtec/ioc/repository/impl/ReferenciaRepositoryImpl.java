package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Referencia;
import cat.xtec.ioc.domain.User;
import cat.xtec.ioc.repository.ReferenciaRepository;
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
@Repository("referenciaRepositoryImpl")
public class ReferenciaRepositoryImpl implements ReferenciaRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Referencia> getAllReferencies() {
        return (List<Referencia>) getSession().createCriteria(Referencia.class).list();
    }

    @Override
    public List<Referencia> getReferenciaBySeccio(String seccio) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("seccio", seccio));
        return (List<Referencia>) criteria.list();
    }

    @Override
    public Referencia getreferenciaByName(String referencia) {
        return getSession().get(Referencia.class, referencia);
    }

    @Override
    public void addReferencia(Referencia referencia) {
        getSession().saveOrUpdate(referencia);
    }

    @Override
    public void updateReferencia(Referencia referencia) {
        getSession().saveOrUpdate(referencia);
    }

    @Override
    public void deleteReferencia(Referencia referencia) {
        getSession().remove(referencia);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Criteria createEntityCriteria() {
        return getSession().createCriteria(Referencia.class);
    }

}
