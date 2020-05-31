package com.tracking.controller;

import com.tracking.model.employee.Department;
import com.tracking.model.employee.Employee;
import com.tracking.service.file.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/img")
public class ImageController {

    private FileStorageService fileStorageService;

    @Autowired
    public ImageController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @GetMapping("/employee/{id}")
    @ResponseBody
    public byte[] getEmployeeAvatar(@PathVariable("id") Long id) throws IOException {
        return this.fileStorageService.loadImage(Employee.class, id);
    }

    @GetMapping("/department/{id}")
    @ResponseBody
    public byte[] getDepartmentAvatar(@PathVariable("id") Long id) throws IOException {
        return this.fileStorageService.loadImage(Department.class, id);
    }

}
