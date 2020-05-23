package com.tracking.service.employee;

import com.tracking.model.employee.Employee;
import com.tracking.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        this.repository.save(employee);
    }

    @Override
    @Transactional
    public Employee findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return this.repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    @Transactional
    public List<String> findAllNums() {
        return this.repository.findAll().stream()
                .map(Employee::getNum)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean containsNum(String num) {
        return findAllNums().stream().anyMatch(dbNum->dbNum.equalsIgnoreCase(num));
    }
}
