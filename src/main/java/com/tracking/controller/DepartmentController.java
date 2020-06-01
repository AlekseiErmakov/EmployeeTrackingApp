package com.tracking.controller;

import com.tracking.model.employee.Department;
import com.tracking.service.employee.DepartmentService;
import com.tracking.service.employee.EmployeeService;
import com.tracking.service.file.FileStorageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/company")
public class DepartmentController {
    private DepartmentService departmentService;
    private FileStorageService fileStorageService;
    private EmployeeService employeeService;

    public DepartmentController(DepartmentService departmentService, FileStorageService fileStorageService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.fileStorageService = fileStorageService;
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public String getCompanyPage() {
        return "company_page";
    }

    @GetMapping("/new")
    public String getNewDepartment(Department department) {
        return "department_form";
    }

    @PostMapping("/save")
    public String saveNewDepartment(@RequestParam("file") MultipartFile file, Department department, BindingResult bindingResult, Model model) {
        Department fromDb = departmentService.save(department);
        if (file != null) {
            fileStorageService.saveImage(file, Department.class, fromDb.getId());
        }
        return "redirect:/company";
    }

    @GetMapping("/department/{id}")
    public String getDepartment(@PathVariable("id") Long id, Model model) {
        Department department = departmentService.findById(id);
        model.addAttribute("department", department);
        return "update_department_form";
    }

    @PostMapping("/update/{id}")
    public String updateDepartment(@RequestParam("file") MultipartFile file, @PathVariable("id") Long id, Model model, Department department) {
        departmentService.update(department, id);
        if (file != null) {
            fileStorageService.saveImage(file, Department.class, id);
        }
        return "redirect:/company";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        this.departmentService.deleteById(id);
        fileStorageService.deleteById(Department.class, id);
        return "redirect:/company";
    }

    @ModelAttribute("workers")
    public Map<Long, Long> getEmployees() {
        return this.employeeService.getAmountOfWorkersByDepartment();
    }

    @ModelAttribute("departments")
    public List<Department> getDepartments() {
        return this.departmentService.findAll();
    }
}
