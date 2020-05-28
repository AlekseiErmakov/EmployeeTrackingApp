package com.tracking.model.tabel;

import com.tracking.model.AbstractEntity;
import com.tracking.model.employee.Department;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class DepartmentTable extends AbstractEntity {

    private Department department;

    private List<EmployeeTable> employeeTables;

    private List<Integer> days = new ArrayList<>();

    private int month;
}
