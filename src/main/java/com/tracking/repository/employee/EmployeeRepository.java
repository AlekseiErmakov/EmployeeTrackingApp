package com.tracking.repository.employee;

import com.tracking.model.employee.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee save(Employee employee);

    void update(Employee employee);

    Employee findById(Long id);

    List<Employee> findAll();

    void deleteById(Long id);
}
