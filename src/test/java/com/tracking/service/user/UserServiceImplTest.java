package com.tracking.service.user;

import com.tracking.model.registration.AppUser;
import com.tracking.model.registration.Role;
import com.tracking.repository.user.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository repository;

    @Mock
    private BCryptPasswordEncoder encoder;

    @Mock
    private RoleService roleService;

    private UserService userService;

    private AppUser alex;

    private AppUser misha;

    private Role admin;

    private Role user;

    @Before
    public void setUp() throws Exception {

        userService = new UserServiceImpl(repository, roleService, encoder);

        admin = new Role();
        admin.setId(1L);
        admin.setName("ROLE_ADMIN");

        user = new Role();
        user.setId(2L);
        user.setName("ROLE_USER");

        alex = new AppUser();
        alex.setId(1L);
        alex.setUsername("alex");
        alex.setPassword("qwerty");
        alex.setEmail("lex_laeda@mail.ru");
        alex.setPhoneNumber("33237");

        misha = new AppUser();
        misha.setId(2L);
        misha.setUsername("misha");
        misha.setPassword("qwerty");

        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(alex, misha));

        Mockito.when(repository.findById(1L)).thenReturn(alex);
    }

    @Test
    public void testFindById() {
        assertEquals(alex, userService.findById(1L));
    }

    @Test
    public void testFindAll() {

        assertEquals(Arrays.asList(alex, misha), userService.findAll());
    }

    @Test
    public void testAddRoleToUser() {
        userService.addRoleToUser(alex, admin);
    }

    @Test
    public void testRemoveRoleFromUser() {
        userService.addRoleToUser(alex, admin);
        userService.removeRoleFromUser(alex, admin);
    }

    @Test
    public void save() {
        Map<String, String> exceptionAttribute = new HashMap<>();
        Mockito.when(repository.findByField("username", alex.getUsername())).thenReturn(null);
        Mockito.when(repository.findByField("email", alex.getEmail())).thenReturn(null);
        Mockito.when(repository.findByField("phoneNumber", alex.getPhoneNumber())).thenReturn(null);

        assertEquals(exceptionAttribute, userService.save(alex));

    }

    @Test
    public void update() {
        alex.setUsername("noAlex");
        userService.update(alex);
        assertEquals(alex, repository.findById(1L));
    }

    @Test
    public void deleteById() {
        userService.deleteById(1L);
    }
}