package com.tracking.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeTableDto extends AbstractDto{
    private List<Long> statusList = new ArrayList<>();
}
