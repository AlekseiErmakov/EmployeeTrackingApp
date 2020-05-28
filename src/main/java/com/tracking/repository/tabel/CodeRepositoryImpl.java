package com.tracking.repository.tabel;

import com.tracking.model.tabel.Code;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class CodeRepositoryImpl implements CodeRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public CodeRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Code> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery<Code> cq = cb.createQuery(Code.class);
        Root<Code> root = cq.from(Code.class);
        cq.select(root);
        Query<Code> query = currentSession.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Code findById(Long codeid) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Code.class, codeid);
    }
}
