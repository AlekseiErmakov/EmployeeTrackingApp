package com.tracking.model.tabel;

import com.tracking.model.AbstractEntity;
import com.tracking.model.employee.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Month;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmployeeTable extends AbstractEntity {
    private Employee employee;
    private List<EmployeeDay> employeeDays;
    private Month month;
}
