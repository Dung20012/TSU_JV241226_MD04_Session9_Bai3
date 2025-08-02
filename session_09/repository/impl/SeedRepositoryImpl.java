package com.data.session_09.repository.impl;

import com.data.session_09.model.entity.Seed;
import com.data.session_09.repository.ISeedRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SeedRepositoryImpl implements ISeedRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Seed> findAll(int page, int size) {
        int offset = (page - 1) * size;
        return sessionFactory.getCurrentSession()
                .createQuery("from Seed", Seed.class)
                .setFirstResult(offset)
                .setMaxResults(size)
                .getResultList();
    }

    @Override
    public Long countTotal() {
        return sessionFactory.getCurrentSession()
                .createQuery("select count(s.id) from Seed s", Long.class)
                .getSingleResult();
    }

    @Override
    public Seed findById(Long id) {
        return sessionFactory.getCurrentSession().get(Seed.class, id);
    }

    @Override
    public void save(Seed seed) {
        sessionFactory.getCurrentSession().save(seed);
    }

    @Override
    public void update(Seed seed) {
        sessionFactory.getCurrentSession().update(seed);
    }

    @Override
    public void delete(Long id) {
        Seed seed = findById(id);
        if (seed != null) {
            sessionFactory.getCurrentSession().delete(seed);
        }
    }
}
