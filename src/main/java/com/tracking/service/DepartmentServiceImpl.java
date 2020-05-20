package com.tracking.service;

import com.tracking.model.employee.Department;
import com.tracking.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    @Transactional
    public void save(Department department) {
        this.departmentRepository.save(department);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.departmentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Department findById(Long id) {
        return this.departmentRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
}
