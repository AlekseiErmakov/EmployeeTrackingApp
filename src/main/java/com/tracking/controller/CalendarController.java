package com.tracking.controller;

import com.tracking.model.Code;
import com.tracking.model.Department;
import com.tracking.service.CodeService;
import com.tracking.service.DepartmentService;
import com.tracking.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller("/calendar")
public class CalendarController {
    private DepartmentService departmentService;
    private CodeService codeService;
    private EmployeeService employeeService;

    @Autowired
    public CalendarController(DepartmentService departmentService, CodeService codeService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.codeService = codeService;
        this.employeeService = employeeService;
    }

    @ModelAttribute("departments")
    public List<Department> getDeparments(){
        return departmentService.findAll();
    }

    @ModelAttribute("codes")
    public List<Code> getCode(){
        return codeService.findAll();
    }

    @GetMapping("/tabel_form")
    public String getCalendarForm(){
        return "tabel_form";
    }
}
