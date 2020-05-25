package com.tracking.model.tabel;

import com.tracking.model.employee.Employee;
import lombok.Data;

import java.util.Set;

@Data
public class EmployeeTable {
    private Employee employee;
    private Set<EmployeeDay> employeeDays;
}
