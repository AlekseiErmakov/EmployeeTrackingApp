package com.tracking.repository.tabel;

import com.tracking.model.employee.Employee;
import com.tracking.model.tabel.EmployeeDay;

import java.util.Set;

public interface EmployeeDayRepository {
    Set<EmployeeDay> getEmployeeDaysByEmployee(Employee employee);
    void saveEmployeeDay(EmployeeDay employeeDay);
}
