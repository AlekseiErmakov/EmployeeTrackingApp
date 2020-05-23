package com.tracking.dto;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class EmployeeDtoTest {
    private EmployeeDto employee;

    private LocalDate birthDayOne;
    private LocalDate birthDayTwo;
    private LocalDate birthDayThree;

    private LocalDate now = LocalDate.now();

    @Before
    public void setUp() throws Exception {
        employee = new EmployeeDto();
    }

    @Test
    public void getIsRemoteTrueDescription() {
        employee.setIsRemote(true);
        assertEquals("Удаленная работа",employee.getIsRemoteDescription());
    }

    @Test
    public void getIsRemoteFalseDescription() {
        employee.setIsRemote(false);
        assertEquals("Работа в офисе",employee.getIsRemoteDescription());
    }

    @Test
    public void testGetAgeBefore() {
        birthDayOne = LocalDate.of(1989, now.getMonth().getValue(), now.getDayOfMonth()-1);
        employee.setBirthday(birthDayOne);
        int yearDiff = getYearDiff(now,birthDayOne);

    }
    @Test
    public void testGetAgeNow(){
        birthDayTwo = LocalDate.of(1989,now.getMonth().getValue(),now.getDayOfMonth());
        employee.setBirthday(birthDayTwo);
        int yearDiff = getYearDiff(now,birthDayTwo);

    }

    @Test
    public void testGetAgeAfter(){
        birthDayThree = LocalDate.of(1989,now.getMonth(),now.getDayOfMonth()+1);
        employee.setBirthday(birthDayThree);
        int yearDiff = getYearDiff(now,birthDayThree);

    }

    private int getYearDiff(LocalDate now, LocalDate birthday){
        return now.getYear() - birthday.getYear();
    }
}