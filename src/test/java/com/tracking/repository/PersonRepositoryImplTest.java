package com.tracking.repository;

import com.tracking.config.HibernateConfig;
import com.tracking.config.WebConfig;
import com.tracking.model.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateConfig.class, WebConfig.class})
@WebAppConfiguration
@Transactional
public class PersonRepositoryImplTest {

    @Resource
    private PersonRepository repository;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void save() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
        List<Person> all = repository.findAll();
    }

    @Test
    public void deleteById() {
    }
}