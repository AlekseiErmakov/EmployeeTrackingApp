package com.tracking.model.tabel;

import com.sun.org.apache.bcel.internal.classfile.Code;
import com.tracking.model.employee.Employee;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDay {
    private Employee employee;
    private LocalDate localDate;
    private Code code;
}
