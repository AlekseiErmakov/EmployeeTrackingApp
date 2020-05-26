package com.tracking.repository.tabel;

import com.tracking.model.employee.Employee;
import com.tracking.model.tabel.EmployeeDay;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface EmployeeDayRepository {
    List<EmployeeDay> getEmployeeDaysByEmployee(Employee employee);
    void saveEmployeeDay(EmployeeDay employeeDay);

    EmployeeDay getEmployeeDayByEmployeeAndDate(Employee employee, LocalDate localDate);
}
