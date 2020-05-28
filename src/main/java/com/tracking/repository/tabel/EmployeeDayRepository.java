package com.tracking.repository.tabel;

import com.tracking.model.employee.Employee;
import com.tracking.model.tabel.EmployeeDay;

import java.util.List;

public interface EmployeeDayRepository {
    List<EmployeeDay> getEmployeeDaysByEmployee(Employee employee);

    void saveEmployeeDay(EmployeeDay employeeDay);

    EmployeeDay findById(Long id);
}
