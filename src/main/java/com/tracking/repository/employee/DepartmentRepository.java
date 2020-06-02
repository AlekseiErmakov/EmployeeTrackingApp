package com.tracking.repository.employee;

import com.tracking.model.employee.Department;

import java.util.List;

public interface DepartmentRepository {
    Department save(Department department);

    void deleteById(Long id);

    Department findById(Long id);

    List<Department> findAll();

    void update(Department department);
}
