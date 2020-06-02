package com.tracking.service.employee;

import com.tracking.model.employee.Department;
import com.tracking.repository.employee.DepartmentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceImplTest {

    private DepartmentService departmentService;
    @Mock
    private DepartmentRepository repository;
    private Department tesla;
    private Department rocketScience;

    @Before
    public void setUp() throws Exception {
        departmentService = new DepartmentServiceImpl(repository);

        tesla = new Department();
        tesla.setId(1L);
        tesla.setName("Tesla");

        rocketScience = new Department();
        rocketScience.setId(2L);
        rocketScience.setName("Rocket Science");
    }

    @Test
    public void testSave() {
        Mockito.when(repository.save(tesla)).thenReturn(tesla);
        assertEquals(tesla,departmentService.save(tesla));
    }


    @Test
    public void testFindById() {
        Mockito.when(repository.findById(1L)).thenReturn(tesla);
        assertEquals(tesla,departmentService.findById(1L));
    }

    @Test
    public void testFindAll() {
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(tesla,rocketScience));
        assertEquals(Arrays.asList(tesla,rocketScience),departmentService.findAll());
    }

    @Test
    public void testUpdate() {
        Mockito.when(repository.findById(1L)).thenReturn(tesla);
        tesla.setName("Name");
        departmentService.update(tesla,1L);
        assertEquals(tesla,departmentService.findById(1L));
    }
}