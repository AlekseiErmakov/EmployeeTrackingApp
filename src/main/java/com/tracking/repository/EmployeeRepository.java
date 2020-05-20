package com.tracking.repository;

import com.tracking.model.employee.Employee;

import java.util.List;

public interface EmployeeRepository {
    void save(Employee employee);
    Employee findById(Long id);
    List<Employee> findAll();
    void deleteById(Long id);
}
