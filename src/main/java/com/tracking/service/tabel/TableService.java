package com.tracking.service.tabel;

import com.tracking.model.employee.Department;
import com.tracking.model.employee.Employee;
import com.tracking.model.tabel.Code;
import com.tracking.model.tabel.DepartmentTable;
import com.tracking.model.tabel.EmployeeTable;

import java.util.List;
import java.util.Set;

public interface TableService {
    DepartmentTable getDepartmentTable(Department department, Set<Employee> employees, int month);
    void saveDepartmentTable(DepartmentTable departmentTable);

    void saveEmployeeTable(Integer month, Employee employee, List<Code> employeeStatusList);

    EmployeeTable getEmployeeTable(Employee employee, Integer month);
}
