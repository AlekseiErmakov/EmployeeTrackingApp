package com.tracking.repository;

import com.tracking.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class PersonRepositoryImpl implements PersonRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public PersonRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Person person) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(person);
    }

    @Override
    public Person findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Person person = currentSession.get(Person.class, id);
        return person;
    }

    @Override
    public List<Person> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> root = cq.from(Person.class);
        cq.select(root);
        Query<Person> query = currentSession.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Person person = currentSession.byId(Person.class).load(id);
        currentSession.delete(person);
    }


}
