package com.tracking.service.employee;

import com.tracking.annotation.custom.FileStorage;
import com.tracking.model.employee.Department;
import com.tracking.repository.employee.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@FileStorage(key = Department.class, location = "image/department/")
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    @Transactional
    public Department save(Department department) {
        return departmentRepository.save(department);
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

    @Override
    @Transactional
    public void update(Department department, Long id) {
        Department fromDb = departmentRepository.findById(id);
        department.setId(fromDb.getId());
        departmentRepository.update(department);
    }
}
