package com.tracking.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmployeeTableDto extends AbstractDto {
    private Long employeeId;
    private Long departmentId;
    private String employeeFullName;
    private String num;
    private List<Long> statusList = new ArrayList<>();
    private List<Integer> emptyCells = new ArrayList<>();
    private String monthTitle;
    private String monthTable;
    private int monthNum;
}
