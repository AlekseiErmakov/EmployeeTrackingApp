package com.tracking.controller;

import com.tracking.model.employee.Department;
import com.tracking.service.employee.DepartmentService;
import com.tracking.service.tabel.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/table")
public class TableController {

    private DepartmentService departmentService;

    private TableService tableService;

    @Autowired
    public TableController(DepartmentService departmentService, TableService tableService) {
        this.departmentService = departmentService;
        this.tableService = tableService;
    }

    @GetMapping("/company")
    public String getCompanyPage(){
        return "company_page";
    }

    @GetMapping("/department/{id}")
    public String getDepartmentTable(@PathVariable("id") Long id, Model model){
        Department department = departmentService.findById(id);
        model.addAttribute("department", department);
        return "department_table";
    }

    @ModelAttribute("departments")
    public List<Department> getDepartments(){
        return this.departmentService.findAll();
    }
}
