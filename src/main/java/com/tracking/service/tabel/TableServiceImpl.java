package com.tracking.service.tabel;

import com.tracking.model.employee.Department;
import com.tracking.model.employee.Employee;
import com.tracking.model.tabel.DepartmentTable;
import com.tracking.model.tabel.EmployeeDay;
import com.tracking.model.tabel.EmployeeTable;
import com.tracking.repository.tabel.EmployeeDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TableServiceImpl implements TableService {

    private EmployeeDayRepository employeeDayRepository;

    @Autowired
    public TableServiceImpl(EmployeeDayRepository employeeDayRepository) {
        this.employeeDayRepository = employeeDayRepository;
    }

    @Override
    public DepartmentTable getDepartmentTable(Department department, int month) {
        Set<Employee> employees = department.getEmployees();
        Set<EmployeeTable> employeeTableSet = employees.stream()
                .map(employee -> getEmployeeTable(employee, getEmployeeDaysByMonth(month,employee)))
                .collect(Collectors.toSet());
        DepartmentTable departmentTable = new DepartmentTable();
        departmentTable.setDepartment(department);
        departmentTable.setEmployeeTables(employeeTableSet);
        return departmentTable;
    }

    @Override
    public void saveDepartmentTable(DepartmentTable departmentTable) {
        departmentTable.getEmployeeTables().stream()
                .flatMap(employeeTable -> employeeTable.getEmployeeDays().stream())
                .forEach(employeeDay -> employeeDayRepository.saveEmployeeDay(employeeDay));
    }

    private Set<EmployeeDay> getEmployeeDaysByMonth(int month,Employee employee){
        return employeeDayRepository.getEmployeeDaysByEmployee(employee).stream()
                .filter(employeeDay -> employeeDay.getLocalDate().getMonth().getValue() == month)
                .collect(Collectors.toSet());
    }

    private EmployeeTable getEmployeeTable(Employee employee, Set<EmployeeDay> employeeDays) {
        EmployeeTable employeeTable = new EmployeeTable();
        employeeTable.setEmployee(employee);
        employeeTable.setEmployeeDays(employeeDays);
        return employeeTable;
    }
}
