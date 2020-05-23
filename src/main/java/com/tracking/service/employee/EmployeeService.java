package com.tracking.service.employee;

import com.tracking.model.employee.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    Employee findById(Long id);
    List<Employee> findAll();
    void deleteById(Long id);

    List<String> findAllNums();

    boolean containsNum(String num);
}
