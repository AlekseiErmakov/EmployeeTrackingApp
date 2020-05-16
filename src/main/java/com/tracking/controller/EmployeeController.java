package com.tracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/employees")
    public String showEmployees() {
        return "/employee_list";
    }

    @GetMapping
    public String addNewEmployee(Model model) {

        return "employee_form";
    }

    public String saveEmployee() {
        return "redirect/";
    }

}
