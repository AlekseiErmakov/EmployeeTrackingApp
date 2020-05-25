package com.tracking.model.tabel;

import com.tracking.model.employee.Department;
import lombok.Data;

import java.util.Set;

@Data
public class DepartmentTable {
    private Department department;
    private Set<EmployeeTable> employeeTables;
}
