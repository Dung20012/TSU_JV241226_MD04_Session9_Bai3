package com.data.session_09.repository.impl;

import com.data.session_09.model.entity.User;
import com.data.session_09.repository.IUserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl implements IUserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User where username =:username", User.class)
                .setParameter("username", username).uniqueResult();
    }
}
