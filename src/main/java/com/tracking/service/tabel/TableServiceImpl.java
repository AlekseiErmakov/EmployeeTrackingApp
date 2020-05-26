package com.tracking.service.tabel;

import com.tracking.model.employee.Department;
import com.tracking.model.employee.Employee;
import com.tracking.model.tabel.Code;
import com.tracking.model.tabel.DepartmentTable;
import com.tracking.model.tabel.EmployeeDay;
import com.tracking.model.tabel.EmployeeTable;
import com.tracking.repository.tabel.EmployeeDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TableServiceImpl implements TableService {

    private EmployeeDayRepository employeeDayRepository;


    @Autowired
    public TableServiceImpl(EmployeeDayRepository employeeDayRepository) {
        this.employeeDayRepository = employeeDayRepository;
    }

    @Override
    @Transactional
    public DepartmentTable getDepartmentTable(Department department, Set<Employee> employees, int month) {
        List<EmployeeTable> employeeTableSet = employees.stream()
                .map(employee -> getEmployeeTable(month,employee, getEmployeeDaysByMonth(month, employee)))
                .collect(Collectors.toList());
        DepartmentTable departmentTable = new DepartmentTable();
        departmentTable.setDepartment(department);
        departmentTable.setEmployeeTables(employeeTableSet);
        int length = getMonthLength(month);
        List<Integer> head = getHead(length);
        departmentTable.setDays(head);
        return departmentTable;
    }


    @Override
    @Transactional
    public void saveDepartmentTable(DepartmentTable departmentTable) {
        departmentTable.getEmployeeTables().stream()
                .flatMap(employeeTable -> employeeTable.getEmployeeDays().stream())
                .forEach(employeeDay -> employeeDayRepository.saveEmployeeDay(employeeDay));
    }

    @Override
    @Transactional
    public void saveEmployeeTable(Integer month, Employee employee, List<Code> employeeStatusList) {
        for(int i = 0; i< employeeStatusList.size(); i++){
            EmployeeDay employeeDay = createEmployeeDay(i + 1, employeeStatusList.get(i), employee, month);
            saveEmployeeDay(employeeDay);
        }
    }

    @Transactional
    public void saveEmployeeDay(EmployeeDay employeeDay){
        employeeDayRepository.saveEmployeeDay(employeeDay);
    }

    private EmployeeDay createEmployeeDay(int day, Code code, Employee employee, Integer month) {
        LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDate.of(now.getYear(),month,day);
        EmployeeDay employeeDayByEmployeeAndDate = employeeDayRepository.getEmployeeDayByEmployeeAndDate(employee, localDate);
        if (employeeDayByEmployeeAndDate != null){
            employeeDayByEmployeeAndDate.setCode(code);
            return employeeDayByEmployeeAndDate;
        }else {
            EmployeeDay employeeDay = new EmployeeDay();
            employeeDay.setCode(code);
            employeeDay.setEmployee(employee);
            employeeDay.setLocalDate(localDate);
            return employeeDay;
        }
    }


    private List<Integer> getHead(int length) {
        List<Integer> head = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            head.add(i);
        }
        return head;
    }

    private int getMonthLength(int month) {
        LocalDate current = LocalDate.now();

        LocalDate date = LocalDate.of(current.getYear(), month, 1);
        return date.getMonth().length(current.isLeapYear());
    }

    private List<EmployeeDay> getEmployeeDaysByMonth(int month, Employee employee) {
        List<EmployeeDay> fromDb = fromDb(month, employee);
        if (fromDb.size() != 0) {
            return fromDb;
        }
        return createNew(month, employee);
    }

    private List<EmployeeDay> createNew(int month, Employee employee) {
        LocalDate current = LocalDate.now();
        int length = getMonthLength(month);
        return Stream.iterate(1, n -> n + 1)
                .limit(length)
                .map(day -> {
                    LocalDate localDate = LocalDate.of(current.getYear(), month, day);
                    EmployeeDay employeeDay = new EmployeeDay(employee, localDate);
                    return employeeDay;
                })
                .collect(Collectors.toList());
    }

    private List<EmployeeDay> fromDb(int month, Employee employee) {
        return employeeDayRepository.getEmployeeDaysByEmployee(employee).stream()
                .filter(employeeDay -> employeeDay.getLocalDate().getMonth().getValue() == month)
                .collect(Collectors.toList());
    }

    private EmployeeTable getEmployeeTable(int month, Employee employee, List<EmployeeDay> employeeDays) {
        EmployeeTable employeeTable = new EmployeeTable();
        employeeTable.setEmployee(employee);
        employeeTable.setEmployeeDays(employeeDays);
        employeeTable.setMonth(month);
        return employeeTable;
    }
}
