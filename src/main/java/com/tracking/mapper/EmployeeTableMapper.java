package com.tracking.mapper;

import com.tracking.dto.EmployeeDto;
import com.tracking.dto.EmployeeTableDto;
import com.tracking.model.employee.Employee;
import com.tracking.model.tabel.Code;
import com.tracking.model.tabel.EmployeeDay;
import com.tracking.model.tabel.EmployeeTable;
import com.tracking.service.tabel.CodeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeTableMapper extends AbstractMapper<EmployeeTable, EmployeeTableDto> {

    private ModelMapper modelMapper;

    private CodeService codeService;

    @Autowired
    public EmployeeTableMapper(ModelMapper modelMapper) {
        super(EmployeeTable.class, EmployeeTableDto.class, modelMapper);
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void initMapper() {
        modelMapper.createTypeMap(EmployeeTable.class, EmployeeTableDto.class)
                .setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(EmployeeTableDto.class, EmployeeTable.class)
                .setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(EmployeeTable source, EmployeeTableDto destination) {
        Employee employee = source.getEmployee();
        List<Long> collect = source.getEmployeeDays().stream()
                .map(employeeDay -> employeeDay.getCode().getId())
                .collect(Collectors.toList());
        destination.setStatusList(collect);
    }

    @Override
    protected void mapSpecificFields(EmployeeTableDto source, EmployeeTable destination) {
        super.mapSpecificFields(source, destination);
    }

}
