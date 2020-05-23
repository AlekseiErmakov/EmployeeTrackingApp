package com.tracking.repository.user;

import com.tracking.config.HibernateConfig;
import com.tracking.config.WebConfig;
import com.tracking.model.registration.Role;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateConfig.class, WebConfig.class})
@WebAppConfiguration
@Transactional
public class RoleRepositoryImplTest {

    @Resource
    private RoleRepository roleRepository;

    private Role user;

    private Role admin;

    private static final String USER_NAME = "USER";

    private static final String ADMIN_NAME = "ADMIN";
    @Before
    public void setUp() throws Exception {
        user = new Role();
        user.setName(USER_NAME);

        admin = new Role();
        admin.setName(ADMIN_NAME);
        roleRepository.save(user);
    }

    @Test
    public void findRoleByName() {
        Role userRoleFromDb = roleRepository.findRoleByName(USER_NAME);
        assertNotNull(userRoleFromDb);
        assertEquals(USER_NAME,userRoleFromDb.getName());
    }

    @Test
    public void findNullRoleByName() {
        Role adminRoleFromDb = roleRepository.findRoleByName(ADMIN_NAME);
        assertNull(adminRoleFromDb);
    }
}