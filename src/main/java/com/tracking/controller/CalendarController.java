package com.tracking.controller;

import com.tracking.model.employee.Department;
import com.tracking.service.CodeService;
import com.tracking.service.DepartmentService;
import com.tracking.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/calendar")
public class CalendarController {
    private DepartmentService departmentService;

    private EmployeeService employeeService;

    @Autowired
    public CalendarController(DepartmentService departmentService, CodeService codeService, EmployeeService employeeService) {
        this.departmentService = departmentService;

        this.employeeService = employeeService;
    }

    @ModelAttribute("departments")
    public List<Department> getDepartments(){
        return departmentService.findAll();
    }

    @GetMapping("/tabel_form")
    public String getCalendarForm(Model model){
        return "tabel_form";
    }

    @GetMapping("/{id}")
    public String getDepartmentTabel(@PathVariable Long id, Model model){
        Department department = departmentService.findById(id);

        model.addAttribute(department);
        return "department_table_form";
    }
}
