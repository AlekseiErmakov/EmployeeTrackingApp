package com.tracking.controller;

import com.tracking.model.Code;
import com.tracking.model.Department;
import com.tracking.service.CodeService;
import com.tracking.service.DepartmentService;
import com.tracking.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
}
