package com.tracking.controller;


import com.tracking.dto.EmployeeTableDto;
import com.tracking.mapper.DepartmentTableMapper;
import com.tracking.model.employee.Department;
import com.tracking.model.employee.Employee;
import com.tracking.model.tabel.Code;
import com.tracking.model.tabel.DepartmentTable;
import com.tracking.model.tabel.EmployeeTable;
import com.tracking.service.employee.DepartmentService;
import com.tracking.service.employee.EmployeeService;
import com.tracking.service.tabel.CodeService;
import com.tracking.service.tabel.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/table")
public class TableController {

    private DepartmentService departmentService;

    private TableService tableService;

    private EmployeeService employeeService;

    private CodeService codeService;

    private DepartmentTableMapper departmentTableMapper;

    @Autowired
    public TableController(DepartmentService departmentService, TableService tableService,
                           EmployeeService employeeService, CodeService codeService,
                           DepartmentTableMapper departmentTableMapper) {
        this.departmentService = departmentService;
        this.tableService = tableService;
        this.employeeService = employeeService;
        this.codeService = codeService;
        this.departmentTableMapper = departmentTableMapper;
    }

    @GetMapping("/company")
    public String getCompanyPage() {
        return "company_page";
    }

    @GetMapping("/department")
    public String getCurrentTable(@RequestParam("id") Long id,
                                  @RequestParam("current") String current, Model model) {
        LocalDate currentDate = LocalDate.now();
        DepartmentTable departmentTable = processTable(id, currentDate.getMonth().getValue());
        model.addAttribute("departmentTable", departmentTable);
        return "department_table";
    }

    @GetMapping("/dep")
    public String getTableByMonth(@RequestParam("id") Long id,
                                  @RequestParam("month") int month, Model model) {
        DepartmentTable departmentTable = processTable(id, month);
        List<EmployeeTable> employeeTables = departmentTable.getEmployeeTables();
        employeeTables.stream().forEach(employeeTable -> employeeTable.getEmployeeDays().stream().forEach(employeeDay -> System.out.println(employeeDay.getCode())));
        model.addAttribute("departmentTable", departmentTable);
        return "department_table";
    }

    @PostMapping("/save/employee")
    public String saveTable(@RequestParam("month") Integer month,
                            @RequestParam("employeeId") Long employeeId, EmployeeTableDto employeeTableDto) {

        List<Code> employeeStatusList = employeeTableDto.getStatusList().stream()
                .map(statusId -> statusId == null ? null : codeService.findById(statusId))
                .collect(Collectors.toList());
        Employee employee = employeeService.findById(employeeId);
        tableService.saveEmployeeTable(month, employee, employeeStatusList);
        return "redirect:/table/dep?id=" + employee.getDepartment().getId() + "&month=" + month;
    }

    @ModelAttribute("departments")
    public List<Department> getDepartments() {
        return this.departmentService.findAll();
    }

    @ModelAttribute("codes")
    public List<Code> getCodes() {
        return this.codeService.findAll();
    }

    @ModelAttribute("employeeTableDto")
    public EmployeeTableDto getEmptyTable() {
        return new EmployeeTableDto();
    }

    private DepartmentTable processTable(Long depId, int month) {
        Department department = departmentService.findById(depId);
        Set<Employee> employees = employeeService.findByDepartment(department);
        DepartmentTable departmentTable = tableService.getDepartmentTable(department, employees, month);
        return departmentTable;
    }
}
