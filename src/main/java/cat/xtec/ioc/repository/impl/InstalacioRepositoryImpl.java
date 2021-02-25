/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Instalacio;
import cat.xtec.ioc.domain.User;
import cat.xtec.ioc.repository.InstalacioRepository;
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
@Repository("instalacioHibernate")
public class InstalacioRepositoryImpl implements InstalacioRepository {

    //Injecció del Bean D'hibernate.(Obtenció d'una sessió d'Hibernate)
    @Autowired
    private SessionFactory sessionFactory;

    //Els mètodes fan servir transaccions (@Transactional)
    @Override
    public Instalacio getInstalacioById(Integer id) {
        Criteria cr = getSession().createCriteria(User.class);
        cr.add(Restrictions.eq("idInstalacio", id));
        return (Instalacio) cr.uniqueResult();
    }

    @Override
    public List<Instalacio> getAllInstalacions() {
        return (List<Instalacio>) getSession().createCriteria(Instalacio.class).list();
    }

    @Override
    public List<Instalacio> getInstalacionsBySeccio(Integer idSeccio) {
        Criteria cr = getSession().createCriteria(User.class);
        cr.add(Restrictions.eq("idInstalacio", idSeccio));
        return (List<Instalacio>) cr.uniqueResult();
    }

    @Override
    public void addInstalacio(Instalacio instalacio) {
        getSession().saveOrUpdate(instalacio);
    }

    @Override
    public void updateInstalacio(Instalacio instalacio) {
        getSession().update(instalacio);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Criteria createEntityCriteria() {
        return getSession().createCriteria(Instalacio.class);
    }

}
