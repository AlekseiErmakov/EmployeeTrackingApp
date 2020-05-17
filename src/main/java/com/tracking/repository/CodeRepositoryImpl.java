package com.tracking.repository;

import com.tracking.model.Code;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Service
public class CodeRepositoryImpl implements CodeRepository{

    private SessionFactory sessionFactory;

    @Autowired
    public CodeRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Code findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Code code = currentSession.get(Code.class, id);
        return code;
    }

    @Override
    public void save(Code code) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(code);
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Code load = currentSession.byId(Code.class).load(id);
        currentSession.delete(load);
    }

    @Override
    public List<Code> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery<Code> cq = cb.createQuery(Code.class);
        Root<Code> from = cq.from(Code.class);
        cq.select(from);
        Query<Code> query = currentSession.createQuery(cq);
        return query.getResultList();
    }
}
