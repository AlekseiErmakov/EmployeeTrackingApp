package com.tracking.service.user;

import com.tracking.model.registration.Role;
import com.tracking.repository.user.RoleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RoleServiceImplTest {

    private RoleService roleService;

    @Mock
    private RoleRepository repository;

    private Role admin;

    private Role user;

    @Before
    public void setUp() throws Exception {
        roleService = new RoleServiceImpl(repository);

        admin = new Role();
        admin.setId(1L);
        admin.setName("ROLE_ADMIN");

        user = new Role();
        user.setId(2L);
        user.setName("ROLE_USER");

        Mockito.when(repository.findById(1L)).thenReturn(admin);
        Mockito.when(repository.findRoleByName("ROLE_ADMIN")).thenReturn(admin);
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(admin, user));
    }

    @Test
    public void testFindById() {
        assertEquals(admin, repository.findById(1L));
    }

    @Test
    public void testFindByName() {
        assertEquals(admin, roleService.findByName("ROLE_ADMIN"));
    }

    @Test
    public void testFindAll() {
        assertEquals(Arrays.asList(admin, user), roleService.findAll());
    }
}