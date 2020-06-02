package com.tracking.service.employee;

import com.tracking.model.employee.Department;
import com.tracking.model.employee.Employee;
import com.tracking.repository.employee.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository repository;

    private EmployeeService employeeService;

    private Employee alex;

    private Employee misha;

    private Department tesla;

    private Department rocketScience;


    private List<String> nums = Arrays.asList("8235","8236");
    @Before
    public void setUp() throws Exception {
        employeeService = new EmployeeServiceImpl(repository);

        tesla = new Department();
        tesla.setId(1L);
        tesla.setName("Tesla");

        rocketScience = new Department();
        rocketScience.setId(2L);
        rocketScience.setName("Rocket Science");

        alex = new Employee();
        alex.setId(1L);
        alex.setNum(nums.get(0));
        alex.setFirstName("Alex");
        alex.setDepartment(tesla);

        misha = new Employee();
        misha.setId(2L);
        misha.setNum(nums.get(1));
        misha.setFirstName("Misha");
        misha.setDepartment(tesla);
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(alex,misha));
    }

    @Test
    public void testSave() {
        Mockito.when(repository.save(alex)).thenReturn(alex);
        Employee save = employeeService.save(alex);
        assertEquals(save,alex);
    }

    @Test
    public void testFindById() {
        Mockito.when(repository.findById(1L)).thenReturn(alex);
        Employee byId = employeeService.findById(1L);
        assertEquals(byId,alex);
    }

    @Test
    public void testFindAll() {

        assertEquals(Arrays.asList(alex,misha),employeeService.findAll());
    }

    @Test
    public void testFindAllNums() {

        assertEquals(nums,employeeService.findAllNums());
    }

    @Test
    public void testContainsNum() {

        assertTrue(employeeService.containsNum(misha.getNum()));
        assertFalse(employeeService.containsNum("8237"));
    }

    @Test
    public void findByDepartment() {
        Set<Employee> employees = new HashSet<>();
        employees.add(alex);
        employees.add(misha);
       assertEquals(employees,employeeService.findByDepartment(tesla));
    }

    @Test
    public void findByEmptyDepartment() {
        Set<Employee> employees = new HashSet<>();
        assertEquals(employees,employeeService.findByDepartment(rocketScience));
    }

    @Test
    public void getAmountOfWorkersByDepartment() {
        Map<Long,Long> amount = new HashMap<>();
        amount.put(1L,2L);
        assertEquals(amount,employeeService.getAmountOfWorkersByDepartment());
    }

    @Test
    public void update() {
        Mockito.when(repository.findById(1L)).thenReturn(alex);
        alex.setFirstName("Name");
        employeeService.update(alex);
        assertEquals(alex,employeeService.findById(1L));
    }
}