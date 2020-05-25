package com.tracking.service.tabel;

import com.tracking.model.employee.Department;
import com.tracking.model.tabel.DepartmentTable;

public interface TableService {
    DepartmentTable getDepartmentTable(Department department, int month);
    void saveDepartmentTable(DepartmentTable departmentTable);
}
