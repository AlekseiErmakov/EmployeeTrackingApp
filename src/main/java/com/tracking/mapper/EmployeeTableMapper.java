package com.tracking.mapper;

import com.tracking.dto.EmployeeTableDto;
import com.tracking.model.employee.Employee;
import com.tracking.model.tabel.EmployeeTable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeTableMapper extends AbstractMapper<EmployeeTable, EmployeeTableDto> {

    private ModelMapper modelMapper;


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
                .map(employeeDay -> employeeDay.getCode() == null ? null : employeeDay.getCode().getId())
                .collect(Collectors.toList());
        destination.setStatusList(collect);
        destination.setEmployeeId(employee.getId());
        destination.setNum(employee.getNum());
        destination.setEmployeeFullName(employee.getFullName());
        String titleMonth = getTitleMonth(source.getMonth());
        String tableMonth = getTableMonth(titleMonth);
        List<Integer> emptyCells = getEmptyCells(source.getMonth());
        destination.setMonthTable(tableMonth);
        destination.setMonthTitle(titleMonth);
        destination.setEmptyCells(emptyCells);
        int value = source.getMonth().getValue();
        destination.setMonthNum(value);
        destination.setDepartmentId(employee.getDepartment().getId());
        List<Integer> endEmptyCells = getEndEmptyCells(emptyCells.size() + value);
        destination.setEndEmptyCells(endEmptyCells);
    }

    private List<Integer> getEmptyCells(Month month) {
        LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDate.of(now.getYear(), month, 1);
        int value = localDate.getDayOfWeek().getValue();
        List<Integer> emptyCells = new ArrayList<>();
        for (int i = 1; i < value; i++) {
            emptyCells.add(i);
        }
        return emptyCells;
    }

    private List<Integer> getEndEmptyCells(int a) {
        int temp;
        int i;
        for (i = 7; i < 50; i += 7) {
            if (i >= a) {
                break;
            }
        }
        List<Integer> emptyCells = new ArrayList<>();
        for (int j = 0; j < i - a; j++) {
            emptyCells.add(j);
        }
        return emptyCells;
    }

    private String getTitleMonth(Month month) {
        switch (month) {
            case JANUARY:
                return "Январь";
            case FEBRUARY:
                return "Февраль";
            case MARCH:
                return "Март";
            case APRIL:
                return "Апрель";
            case MAY:
                return "Май";
            case JUNE:
                return "Июнь";
            case JULY:
                return "Июль";
            case AUGUST:
                return "Август";
            case SEPTEMBER:
                return "Сентрябрь";
            case OCTOBER:
                return "Октябрь";
            case NOVEMBER:
                return "Ноябрь";
            case DECEMBER:
                return "Декабрь";
        }
        return null;
    }

    private String getTableMonth(String month) {
        switch (month) {
            case "Март":
            case "Август":
                return " " + month + "а";
            default:
                return " " + month.substring(0, month.length() - 1) + "я";
        }
    }

}
