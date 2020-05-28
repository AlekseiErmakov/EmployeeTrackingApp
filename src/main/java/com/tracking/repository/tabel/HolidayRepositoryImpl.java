package com.tracking.repository.tabel;

import com.tracking.model.tabel.Holiday;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class HolidayRepositoryImpl implements HolidayRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public HolidayRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Holiday> findHolidaysByMonth(LocalDate start, LocalDate end) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Holiday> query = currentSession.createQuery("FROM Holiday WHERE date BETWEEN :dateStart AND :dateEnd", Holiday.class);
        query.setParameter("dateStart", start);
        query.setParameter("dateEnd", end);
        return query.getResultList();
    }
}
