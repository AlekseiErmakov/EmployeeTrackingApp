package com.tracking.controller;

import com.tracking.model.Department;
import com.tracking.model.Employee;
import com.tracking.model.Post;
import com.tracking.service.DepartmentService;
import com.tracking.service.EmployeeService;
import com.tracking.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private DepartmentService departmentService;
    private PostService postService;
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(DepartmentService departmentService, PostService postService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.postService = postService;
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public String showEmployees() {
        return "/employee_list";
    }

    @GetMapping("/new")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "employee_form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        return "redirect/";
    }

    @ModelAttribute("departments")
    public List<Department> getDepatments(){
        return this.departmentService.findAll();
    }

    @ModelAttribute("posts")
    public List<Post> getPosts() {
        return this.postService.findAll();
    }
}
