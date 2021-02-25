/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Seccio;
import cat.xtec.ioc.domain.User;
import cat.xtec.ioc.repository.SeccioRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JoseAndrade
 */
@Transactional
@Repository("seccioRepositoryImpl")
public class SeccioRepositoryImpl implements SeccioRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Seccio> getAllSeccions() {
        return (List<Seccio>) getSession().createCriteria(Seccio.class).list();
    }

    @Override
    public Seccio getProcessByName(String nomSeccio) {
        Criteria cr = getSession().createCriteria(Seccio.class);
        cr.add(Restrictions.eq("nom", nomSeccio));
        return (Seccio) cr.uniqueResult();
    }

    @Override
    public Seccio getSeccioById(int idSeccio) {
        return getSession().get(Seccio.class, idSeccio);
    }

    @Override
    public void addSeccio(Seccio seccio) {
        getSession().saveOrUpdate(seccio);
    }

    @Override
    public void updateSeccio(Seccio seccio) {
        getSession().saveOrUpdate(seccio);
    }

    @Override
    public void deleteSeccio(Seccio seccio) {
        getSession().delete(seccio);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Criteria createEntityCriteria() {
        return getSession().createCriteria(Session.class);
    }

}
