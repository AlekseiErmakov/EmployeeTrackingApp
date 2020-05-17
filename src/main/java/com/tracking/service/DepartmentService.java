package com.tracking.service;

import com.tracking.model.Department;

import java.util.List;

public interface DepartmentService {
    void save(Department department);

    void deleteById(Long id);

    Department findById(Long id);

    List<Department> findAll();
}
