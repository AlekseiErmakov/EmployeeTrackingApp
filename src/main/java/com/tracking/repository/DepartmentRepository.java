package com.tracking.repository;

import com.tracking.model.employee.Department;

import java.util.List;

public interface DepartmentRepository {
    void save(Department department);

    void deleteById(Long id);

    Department findById(Long id);

    List<Department> findAll();
}
