package com.tracking.service.tabel;

import com.tracking.model.employee.Employee;
import com.tracking.model.tabel.EmployeeDay;
import com.tracking.repository.tabel.EmployeeDayRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDayServiceImplTest {

    @Mock
    private EmployeeDayRepository repository;

    private EmployeeDayService employeeDayService;

    private Employee alex;

    private Employee misha;

    private EmployeeDay monday;

    private EmployeeDay thuesday;

    @Before
    public void setUp() throws Exception {

        employeeDayService = new EmployeeDayServiceImpl(repository);

        alex = new Employee();
        alex.setId(1L);
        alex.setFirstName("Alex");

        monday = new EmployeeDay();
        monday.setId(1L);
        monday.setEmployee(alex);
        monday.setLocalDate(LocalDate.of(2020, 6, 1));

        thuesday = new EmployeeDay();
        thuesday.setId(2L);
        thuesday.setEmployee(misha);
        thuesday.setLocalDate(LocalDate.of(2020, 6, 2));

        Mockito.when(repository.findById(1L)).thenReturn(monday);
        Mockito.when(repository.getEmployeeDaysByEmployee(alex)).thenReturn(Arrays.asList(monday, thuesday));
        Mockito.when(repository.getEmployeeDaysByEmployee(alex)).thenReturn(Arrays.asList(monday, thuesday));
    }

    @Test
    public void findById() {

        assertEquals(monday, employeeDayService.findById(1L));
    }


    @Test
    public void getEmployeeDaysByEmployee() {
        assertEquals(Arrays.asList(monday, thuesday), employeeDayService.getEmployeeDaysByEmployee(alex));

    }

    @Test
    public void getEmployeeDayByEmployeeAndDate() {
        assertEquals(thuesday, employeeDayService.getEmployeeDayByEmployeeAndDate(alex, LocalDate.of(2020, 6, 2)));
    }
}