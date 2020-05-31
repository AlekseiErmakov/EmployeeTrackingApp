package com.tracking.service.employee;

import com.tracking.annotation.custom.FileStorage;
import com.tracking.model.employee.Department;
import com.tracking.model.employee.Employee;
import com.tracking.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@FileStorage(key = Employee.class,location = "image/employee/")
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return this.repository.save(employee);
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
        return findAllNums().stream().anyMatch(dbNum -> dbNum.equalsIgnoreCase(num));
    }

    @Override
    @Transactional
    public Set<Employee> findByDepartment(Department department) {
        Set<Employee> nen = this.repository.findAll().stream()
                .filter(employee -> department.getName().equals(employee.getDepartment().getName()))
                .collect(Collectors.toSet());
        return nen;
    }

    @Override
    @Transactional
    public Map<Long, Long> getAmountOfWorkersByDepartment() {
        return repository.findAll().stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment().getId(), Collectors.counting()));
    }
}
