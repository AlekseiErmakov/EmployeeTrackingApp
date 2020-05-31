package com.tracking.service.employee;

import com.tracking.model.employee.Department;

import java.util.List;

public interface DepartmentService {
    Department save(Department department);

    void deleteById(Long id);

    Department findById(Long id);

    List<Department> findAll();

    void update(Department department, Long id);

}
