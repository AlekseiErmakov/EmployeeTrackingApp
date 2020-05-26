package com.tracking.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DepartmentTableDto extends AbstractDto {
    private Long id;
    private String departmentName;
    private List<EmployeeTableDto> employeeTableDtoList = new ArrayList<>();
    private List<Integer> days = new ArrayList<>();
}
