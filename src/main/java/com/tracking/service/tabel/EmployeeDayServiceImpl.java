package com.tracking.service.tabel;

import com.tracking.model.employee.Employee;
import com.tracking.model.tabel.EmployeeDay;
import com.tracking.repository.tabel.EmployeeDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeDayServiceImpl implements EmployeeDayService {

    private EmployeeDayRepository employeeDayRepository;

    @Autowired
    public EmployeeDayServiceImpl(EmployeeDayRepository employeeDayRepository) {
        this.employeeDayRepository = employeeDayRepository;
    }

    @Override
    @Transactional
    public EmployeeDay findById(Long id) {
        return employeeDayRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(EmployeeDay employeeDay) {
        employeeDayRepository.saveEmployeeDay(employeeDay);
    }

    @Override
    @Transactional
    public List<EmployeeDay> getEmployeeDaysByEmployee(Employee employee) {
        return employeeDayRepository.getEmployeeDaysByEmployee(employee);
    }

    @Override
    @Transactional
    public EmployeeDay getEmployeeDayByEmployeeAndDate(Employee employee, LocalDate localDate) {
        return employeeDayRepository.getEmployeeDaysByEmployee(employee).stream()
                .filter(employeeDay -> employeeDay.getLocalDate().equals(localDate))
                .findFirst().orElse(null);
    }
}
