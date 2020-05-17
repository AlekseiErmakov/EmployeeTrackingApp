package com.tracking.service;

import com.tracking.model.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    Employee findById(Long id);
    List<Employee> findAll();
    void deleteById(Long id);
}
