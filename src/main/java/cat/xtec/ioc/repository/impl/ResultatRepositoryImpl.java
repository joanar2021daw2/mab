package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Resultat;
import cat.xtec.ioc.repository.ResultatRepository;
import java.util.List;
import java.util.Set;
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
@Repository("resultatRepositoryImpl")
public class ResultatRepositoryImpl implements ResultatRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createResultat(Resultat resultat) {
        getSession().saveOrUpdate(resultat);
    }

    @Override
    public List<Resultat> getResultatsByUsuari(Integer numOperari) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("numOperari", numOperari));
        return (List<Resultat>) criteria.list();
    }

    @Override
    public Resultat getResultatById(Integer idReferencia) {
        return getSession().get(Resultat.class, idReferencia);
    }

    @Override
    public List<Resultat> getAllResultats() {
        return (List<Resultat>) getSession().createCriteria(Resultat.class).list();
    }

    @Override
    public void removeResultat(Resultat resultat) {
        getSession().remove(resultat);
    }

    @Override
    public void updateResultat(Resultat resultat) {
        getSession().saveOrUpdate(resultat);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Criteria createEntityCriteria() {
        return getSession().createCriteria(Resultat.class);
    }

 

}
