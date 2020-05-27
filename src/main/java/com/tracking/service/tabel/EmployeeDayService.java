package com.tracking.service.tabel;

import com.tracking.model.employee.Employee;
import com.tracking.model.tabel.EmployeeDay;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public interface EmployeeDayService {

    EmployeeDay findById(Long id);

    void save(EmployeeDay employeeDay);

    List<EmployeeDay> getEmployeeDaysByEmployee(Employee employee);

    EmployeeDay getEmployeeDayByEmployeeAndDate(Employee employee, LocalDate localDate);

}
