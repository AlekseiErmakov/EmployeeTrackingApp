package com.tracking.repository.employee;

import com.tracking.model.employee.Department;
import com.tracking.model.employee.Employee;

import java.util.List;
import java.util.Set;

public interface EmployeeRepository {
    void save(Employee employee);
    Employee findById(Long id);
    List<Employee> findAll();
    void deleteById(Long id);
}
