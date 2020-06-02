package com.tracking.model.employee;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee alex;
    private int age = 30;
    private String firstName = "Alex";
    private String lastName = "Ermakov";
    private LocalDate now = LocalDate.now();
    private LocalDate birtday = now.minusYears(age);

    @Before
    public void setUp() throws Exception {
        alex = new Employee();
        alex.setFirstName(firstName);
        alex.setLastName(lastName);
        alex.setBirthday(birtday);

    }

    @Test
    public void getFullName() {
        assertEquals(firstName + " " + lastName,alex.getFullName());
    }

    @Test
    public void getIsRemoteDescription() {
        alex.setIsRemote(true);
        assertEquals("Удаленная работа",alex.getIsRemoteDescription());
    }
    @Test
    public void getIsNotRemoteDescription() {
        alex.setIsRemote(false);
        assertEquals("Работа в офисе",alex.getIsRemoteDescription());
    }

    @Test
    public void getAge() {
        assertEquals(age,alex.getAge());
    }
}