package com.tracking.mapper;

import com.tracking.dto.DepartmentTableDto;
import com.tracking.dto.EmployeeTableDto;
import com.tracking.model.tabel.DepartmentTable;
import com.tracking.model.tabel.EmployeeTable;
import com.tracking.service.employee.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentTableMapper extends AbstractMapper<DepartmentTable, DepartmentTableDto> {


    private ModelMapper modelMapper;

    private EmployeeTableMapper employeeTableMapper;

    private DepartmentService departmentService;

    @Autowired
    public DepartmentTableMapper(ModelMapper modelMapper, DepartmentService departmentService, EmployeeTableMapper employeeTableMapper) {
        super(DepartmentTable.class, DepartmentTableDto.class, modelMapper);
        this.modelMapper = modelMapper;
        this.departmentService = departmentService;
        this.employeeTableMapper = employeeTableMapper;
    }

    @PostConstruct
    public void initMapper() {
        modelMapper.createTypeMap(DepartmentTable.class, DepartmentTableDto.class)
                .setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(DepartmentTableDto.class, DepartmentTable.class)
                .setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(DepartmentTableDto source, DepartmentTable destination) {
        destination.setDepartment(departmentService.findById(source.getId()));
        List<EmployeeTable> collect = source.getEmployeeTableDtoList().stream()
                .map(employeeTableDto -> employeeTableMapper.toEntity(employeeTableDto))
                .collect(Collectors.toList());
        destination.setEmployeeTables(collect);
    }

    @Override
    protected void mapSpecificFields(DepartmentTable source, DepartmentTableDto destination) {
        destination.setDays(source.getDays());
        destination.setDepartmentName(source.getDepartment().getName());
        destination.setId(source.getDepartment().getId());
        List<EmployeeTableDto> collect = source.getEmployeeTables().stream()
                .map(employeeTable -> employeeTableMapper.toDto(employeeTable))
                .collect(Collectors.toList());
        destination.setEmployeeTableDtoList(collect);
    }
}
