package com.tracking.repository.employee;

import com.tracking.config.AppConfig;
import com.tracking.config.HibernateConfig;
import com.tracking.model.employee.Department;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class })
@Transactional
@WebAppConfiguration
public class DepartmentRepositoryImplTest {

    @Resource
    private DepartmentRepository departmentRepository;

    private Department tesla;
    private Department rocketScience;

    @Before
    public void setUp() throws Exception {
        tesla = new Department();
        tesla.setName("Tesla");
        tesla.setId(1L);


        rocketScience = new Department();
        rocketScience.setName("Rocket Science");
        rocketScience.setId(2L);
        departmentRepository.save(tesla);
        departmentRepository.save(rocketScience);
    }

    @Test
    public void save() {

        assertEquals(2,departmentRepository.findAll().size());
    }

    @Test
    public void deleteById() {
        departmentRepository.deleteById(tesla.getId());
        assertEquals(1,departmentRepository.findAll().size());
    }

    @Test
    public void findById() {
        Department byId = departmentRepository.findById(tesla.getId());
        assertEquals(tesla,byId);
    }

    @Test
    public void findAll() {
        assertEquals(Arrays.asList(tesla,rocketScience),departmentRepository.findAll());
    }

    @Test
    public void update() {
        tesla.setName("NoTesla");
        departmentRepository.update(tesla);
        assertEquals(tesla,departmentRepository.findById(tesla.getId()));
    }
}