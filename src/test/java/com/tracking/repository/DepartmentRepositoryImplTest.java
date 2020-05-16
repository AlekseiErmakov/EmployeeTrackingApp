package com.tracking.repository;

import com.tracking.config.HibernateConfig;
import com.tracking.config.WebConfig;
import com.tracking.model.Department;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class, WebConfig.class})
@WebAppConfiguration
@Transactional
public class DepartmentRepositoryImplTest {
    @Resource
    private DepartmentRepository repository;

    private Department development;

    @Before
    public void setUp() throws Exception {
        development = new Department();
        development.setName("Development department");

    }

    @Test
    public void testSave() {
        repository.save(development);
        List<Department> all = repository.findAll();
        assertTrue(all.contains(development));
    }

    @Test
    public void testDeleteById() {
        repository.save(development);
        Department department = repository.findAll().get(0);
        Long id = department.getId();
        repository.deleteById(id);
        List<Department> all = repository.findAll();
        assertEquals(0,all.size());
    }

    @Test
    public void testFindById() {
        repository.save(development);
        Department department = repository.findAll().get(0);
        Long id = department.getId();
        Department byId = repository.findById(id);
        assertEquals(development,byId);
    }

    @Test
    public void testFindAll() {
        repository.save(development);
        List<Department> all = repository.findAll();
        assertEquals(1,all.size());
    }
}