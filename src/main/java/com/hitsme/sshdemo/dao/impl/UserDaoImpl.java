package com.hitsme.sshdemo.dao.impl;

import com.hitsme.sshdemo.entity.User;
import com.hitsme.sshdemo.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mgl
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    @Override
    public User load(Long id) {
        return (User) getCurrentSession().load(User.class, id);
    }

    @Override
    public User get(Long id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void persist(User entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public Long save(User entity) {
        return (Long) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(User entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Long id) {
        User User = load(id);
        getCurrentSession().delete(User);
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }
}
