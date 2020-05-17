package com.tracking.repository;

import com.tracking.model.Absence;
import com.tracking.model.Employee;

import java.util.List;

public interface AbsenceRepository {
    void save(Absence absence);
    Absence findById(Long id);
    void deleteByID(Long id);
    List<Absence> findAll();
    List<Absence> findAllByEmployee(Employee employee);
}
