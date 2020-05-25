package com.tracking.controller;

import com.tracking.dto.EmployeeDto;
import com.tracking.mapper.EmployeeMapper;
import com.tracking.model.employee.Department;
import com.tracking.model.employee.Employee;
import com.tracking.model.employee.Post;
import com.tracking.service.employee.DepartmentService;
import com.tracking.service.employee.EmployeeService;
import com.tracking.service.employee.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    private EmployeeService employeeService;
    private DepartmentService departmentService;
    private PostService postService;
    private EmployeeMapper employeeMapper;


    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService,
                              PostService postService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.postService = postService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping("/new")
    public String getEmployeeForm(EmployeeDto employeeDto) {
        return "employee_form";
    }

    @PostMapping("/save")
    public String saveNewEmployee(EmployeeDto employeeDto) {

        if (employeeService.containsNum(employeeDto.getNum())) {
            employeeDto.setNum("Работник с таким номером уже существует");
            return "employee_form";
        }
        Employee employee = employeeMapper.toEntity(employeeDto);
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/list")
    public String getEmployeeList() {
        return "employee_list";
    }

    @GetMapping("/update/{id}")
    public String getEmployeeById(@PathVariable("id") Long id, Model model) {
        Employee update = employeeService.findById(id);
        EmployeeDto employeeDto = employeeMapper.toDto(update);
        model.addAttribute("employeeDto", employeeDto);
        return "update_employee_form";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") Long id, EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEntity(employeeDto);
        employee.setId(id);
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        this.employeeService.deleteById(id);
        return "redirect:/employee/list";
    }

    @ModelAttribute("departments")
    public List<Department> getDepartments() {
        return this.departmentService.findAll();
    }

    @ModelAttribute("posts")
    public List<Post> getPosts() {
        return this.postService.findAll();

    }

    @ModelAttribute("employees")
    public List<EmployeeDto> getEmployees() {
        return this.employeeService.findAll().stream()
                .map(employee -> employeeMapper.toDto(employee))
                .collect(Collectors.toList());
    }

}
