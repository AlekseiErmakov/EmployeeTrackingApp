package com.tracking.service.employee;

import com.tracking.model.employee.Department;
import com.tracking.model.employee.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface EmployeeService {
    Employee save(Employee employee);

    Employee findById(Long id);

    List<Employee> findAll();

    void deleteById(Long id);

    List<String> findAllNums();

    boolean containsNum(String num);

    Set<Employee> findByDepartment(Department department);

    Map<Long,Long> getAmountOfWorkersByDepartment();
}
