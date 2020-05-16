package com.tracking.repository;

import com.tracking.config.HibernateConfig;
import com.tracking.config.WebConfig;
import com.tracking.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateConfig.class, WebConfig.class})
@WebAppConfiguration
@Transactional
public class EmployeeRepositoryImplTest {

    @Resource
    private EmployeeRepository repository;

    private Employee aleksey;
    private Employee evgeniia;
    private Department backend;
    private Post javaDev;
    private Post jsDev;
    @Before
    public void setUp() throws Exception {
        backend = new Department();
        backend.setName("Backend");

        javaDev = new Post();
        javaDev.setName("java developer");

        jsDev = new Post();
        jsDev.setName("javaScript developer");

        Address address = new Address();
        address.setCity("Saint-Petersburg");
        address.setStreet("Stachek");
        address.setHouse("26");
        address.setFlat(12);

        Contact alexCon = new Contact();
        alexCon.setEmail("lex_laeda@mail.ru");
        alexCon.setPhone("+7(911)7494312");

        Contact zhenCon = new Contact();
        zhenCon.setEmail("lex_laeda@mail.ru");
        zhenCon.setPhone("+7(911)7494312");

        aleksey = new Employee();
        aleksey.setFirstName("Aleksey");
        aleksey.setLastName("Ermakov");
        aleksey.setBirthday(LocalDate.of(1989,11,30));
        aleksey.setIsRemote(true);
        aleksey.setAddress(address);
        aleksey.setDepartment(backend);
        aleksey.setPost(javaDev);
        aleksey.setSex(Sex.MALE);
        aleksey.setNum("8435");
        aleksey.setContact(alexCon);

        evgeniia = new Employee();
        evgeniia.setFirstName("Evgeniia");
        evgeniia.setLastName("Russkikh");
        evgeniia.setBirthday(LocalDate.of(1993,12,4));
        evgeniia.setIsRemote(false);
        evgeniia.setAddress(address);
        evgeniia.setDepartment(backend);
        evgeniia.setPost(jsDev);
        evgeniia.setSex(Sex.FEMALE);
        evgeniia.setNum("8436");
        evgeniia.setContact(zhenCon);

    }

    @Test
    public void testSave() {
        repository.save(aleksey);
        List<Employee> all = repository.findAll();
        assertEquals(1,all.size());
    }

    @Test
    public void testFindById() {
        repository.save(aleksey);
        Employee employee = repository.findAll().get(0);
        Employee byId = repository.findById(employee.getId());
        assertEquals(employee,byId);
    }

    @Test
    public void testFindAll() {
        repository.save(aleksey);
        repository.save(evgeniia);
        List<Employee> all = repository.findAll();
        assertEquals(2,all.size());
    }

    @Test
    public void testDeleteById() {
        repository.save(aleksey);
        Employee employee = repository.findAll().get(0);
        Employee byId = repository.findById(employee.getId());
        repository.deleteById(byId.getId());
        assertEquals(0,repository.findAll().size());
    }
}