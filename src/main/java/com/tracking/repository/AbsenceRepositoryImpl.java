package com.tracking.repository;

import com.tracking.model.Absence;
import com.tracking.model.Employee;
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
public class AbsenceRepositoryImpl implements AbsenceRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public AbsenceRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Absence absence) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(absence);
    }

    @Override
    public Absence findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Absence absence = currentSession.get(Absence.class, id);
        return absence;
    }

    @Override
    public void deleteByID(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Absence load = currentSession.byId(Absence.class).load(id);
        currentSession.delete(load);
    }

    @Override
    public List<Absence> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Absence> cq = criteriaBuilder.createQuery(Absence.class);
        Root<Absence> from = cq.from(Absence.class);
        cq.select(from);
        Query<Absence> query = currentSession.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Absence> findAllByEmployee(Employee employee) {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery<Absence> cq = cb.createQuery(Absence.class);
        Root<Absence> root = cq.from(Absence.class);
        return null;
    }
}
