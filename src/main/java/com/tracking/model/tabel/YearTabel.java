package com.tracking.model.tabel;

import com.tracking.model.employee.Employee;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public class YearTabel {
    private Long id;
    private Year year;
    private Employee employee;
    private Set<MonthTabel> monthTabels = new HashSet<>();
}
