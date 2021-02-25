/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.User;
import cat.xtec.ioc.repository.UserRepository;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JoseAndrade
 */
@Transactional
@Repository("userRepositoryImpl")
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        return (List<User>) getSession().createCriteria(User.class).list();
    }

    @Override
    public List<User> getUserBySeccio(String seccio) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("seccio", seccio));
        return (List<User>) criteria.list();
    }

    @Override
    public User getUserByNumOperari(Integer numOperari) {
        Criteria cr = getSession().createCriteria(User.class);
        cr.add(Restrictions.eq("numOperari", numOperari));
        return (User) cr.uniqueResult();
    }

    @Override
    public User getUserByNom(String nom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", nom));
        return (User) criteria.uniqueResult();
    }

    @Override
    public void createUser(User user) {
        getSession().saveOrUpdate(user);
    }

    @Override
    public void removeUser(User user) {
        getSession().delete(user);
    }

    @Override
    public void updateUser(User user) {
        getSession().saveOrUpdate(user);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Criteria createEntityCriteria() {
        return getSession().createCriteria(User.class);
    }

    @Override
    public User getUserById(Integer id) {
        Criteria cr = getSession().createCriteria(User.class);
        cr.add(Restrictions.eq("userId", id));
        return (User) cr.uniqueResult();
    }

}
