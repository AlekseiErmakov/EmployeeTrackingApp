package com.tracking.controller;

import com.tracking.dto.EmployeeDto;
import com.tracking.mapper.EmployeeMapper;
import com.tracking.model.*;
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
    private EmployeeMapper mapper;

    @Autowired
    public EmployeeController(DepartmentService departmentService, PostService postService, EmployeeService employeeService, EmployeeMapper mapper) {
        this.departmentService = departmentService;
        this.postService = postService;
        this.employeeService = employeeService;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public String showEmployees() {
        return "/employee_list";
    }

    @GetMapping("/new")
    public String addNewEmployee(Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute(employeeDto);
        return "employee_form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employeeDto") EmployeeDto employeeDto) {
        Employee employee = mapper.toEntity(employeeDto);
        employeeService.save(employee);
        return "redirect:all";
    }

    @ModelAttribute("departments")
    public List<Department> getDepatments(){
        return this.departmentService.findAll();
    }

    @ModelAttribute("posts")
    public List<Post> getPosts() {
        return this.postService.findAll();

    }
    @ModelAttribute("employees")
    public List<Employee> getEmployees(){
        List<Employee> all = this.employeeService.findAll();
        for (Employee employee : all){
            Address address = employee.getAddress();
            System.out.println(address);
        }
        return all;
    }
}
