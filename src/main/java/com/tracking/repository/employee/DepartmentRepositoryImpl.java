package com.tracking.repository.employee;

import com.tracking.model.employee.Department;
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
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public DepartmentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Department save(Department department) {
        Session currentSession = sessionFactory.getCurrentSession();
        Long depId = (Long) currentSession.save(department);
        Department fromDb = currentSession.get(Department.class, depId);
        return fromDb;
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Department load = currentSession.byId(Department.class).load(id);
        currentSession.delete(load);
    }

    @Override
    public Department findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Department department = currentSession.get(Department.class, id);
        return department;
    }

    @Override
    public List<Department> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery<Department> cq = cb.createQuery(Department.class);
        Root<Department> from = cq.from(Department.class);
        cq.select(from);
        Query<Department> query = currentSession.createQuery(cq);
        return query.getResultList();
    }
}
