package com.tracking.repository.user;

import com.tracking.model.registration.Role;
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
public class RoleRepositoryImpl implements RoleRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public RoleRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role findRoleByName(String name) {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> root = cq.from(Role.class);
        cq.select(root).where(cb.equal(root.get("name"),name));
        Query<Role> query = currentSession.createQuery(cq);
        try {
            Role singleResult = query.getSingleResult();
            return singleResult;
        }catch (NoResultException ex){
            return null;
        }

    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Role load = currentSession.load(Role.class, id);
        currentSession.delete(load);
    }

    @Override
    public void save(Role role) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(role);
    }

    @Override
    public Role findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Role role = currentSession.find(Role.class, id);
        return role;
    }

    @Override
    public List<Role> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> root = cq.from(Role.class);
        cq.select(root);
        Query<Role> query = currentSession.createQuery(cq);
        return query.getResultList();
    }
}
