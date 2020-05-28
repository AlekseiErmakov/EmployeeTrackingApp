package com.tracking.repository.user;

import com.tracking.model.registration.AppUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public AppUser findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.find(AppUser.class, id);
    }

    @Override
    public void save(AppUser appUser) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(appUser);
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        AppUser load = currentSession.load(AppUser.class, id);
        currentSession.delete(load);
    }

    @Override
    public List<AppUser> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery<AppUser> cq = cb.createQuery(AppUser.class);
        Root<AppUser> root = cq.from(AppUser.class);
        cq.select(root);
        Query<AppUser> query = currentSession.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public AppUser findByField(String field, String value) {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery<AppUser> cq = cb.createQuery(AppUser.class);
        Root<AppUser> root = cq.from(AppUser.class);
        cq.select(root).where(cb.equal(root.get(field), value));
        Query<AppUser> query = currentSession.createQuery(cq);
        try {
            AppUser singleResult = query.getSingleResult();
            return singleResult;
        } catch (NoResultException ex) {
            return null;
        }
    }
}
