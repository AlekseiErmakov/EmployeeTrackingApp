package com.tracking.controller;


import com.tracking.dto.EmployeeTableDto;
import com.tracking.mapper.EmployeeTableMapper;
import com.tracking.model.employee.Department;
import com.tracking.model.employee.Employee;
import com.tracking.model.tabel.Code;
import com.tracking.model.tabel.DepartmentTable;
import com.tracking.model.tabel.EmployeeTable;
import com.tracking.service.employee.DepartmentService;
import com.tracking.service.employee.EmployeeService;
import com.tracking.service.tabel.CodeService;
import com.tracking.service.tabel.HolidayService;
import com.tracking.service.tabel.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/table")
public class TableController {

    private DepartmentService departmentService;

    private TableService tableService;

    private EmployeeService employeeService;

    private CodeService codeService;

    private HolidayService holidayService;

    private EmployeeTableMapper employeeTableMapper;


    @Autowired
    public TableController(DepartmentService departmentService, TableService tableService,
                           EmployeeService employeeService, CodeService codeService,
                           HolidayService holidayService, EmployeeTableMapper employeeTableMapper
    ) {
        this.departmentService = departmentService;
        this.tableService = tableService;
        this.employeeService = employeeService;
        this.codeService = codeService;
        this.holidayService = holidayService;
        this.employeeTableMapper = employeeTableMapper;
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
        List<Integer> holidays = holidayService.getHolidayDatesByMonth(currentDate.getMonth().getValue());
        model.addAttribute("holidays", holidays);
        model.addAttribute("departmentTable", departmentTable);
        return "department_table";
    }

    @GetMapping("/dep")
    public String getTableByMonth(@RequestParam("id") Long id,
                                  @RequestParam("month") int month, Model model) {
        DepartmentTable departmentTable = processTable(id, month);
        List<Integer> holidays = holidayService.getHolidayDatesByMonth(month);
        model.addAttribute("holidays", holidays);
        model.addAttribute("departmentTable", departmentTable);
        return "department_table";
    }

    @GetMapping("/employee")
    public String getEmployeeMonthTable(@RequestParam("id") Long id,
                                        @RequestParam("month") Integer month, Model model) {
        Employee employee = employeeService.findById(id);
        List<Integer> holidays = holidayService.getHolidayDatesByMonth(month);
        EmployeeTable employeeTable = tableService.getEmployeeTable(employee, month);
        EmployeeTableDto employeeTableDto = employeeTableMapper.toDto(employeeTable);
        model.addAttribute("holidays", holidays);
        model.addAttribute("employeeTableDto", employeeTableDto);
        return "employee_table";
    }

    @PostMapping("/save/employee")
    public String saveEmployeeTable(@RequestParam("id") Long employeeId,
                                    @RequestParam("month") int month,
                                    EmployeeTableDto employeeTableDto) {
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

    @ModelAttribute("months")
    public List<String> getMonths() {
        return Arrays.asList("Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь");
    }

    @ModelAttribute("workers")
    public Map<Long,Long> getEmployees(){
        return employeeService.getAmountOfWorkersByDepartment();
    }

    private DepartmentTable processTable(Long depId, int month) {
        Department department = departmentService.findById(depId);
        Set<Employee> employees = employeeService.findByDepartment(department);
        DepartmentTable departmentTable = tableService.getDepartmentTable(department, employees, month);
        return departmentTable;
    }
}
