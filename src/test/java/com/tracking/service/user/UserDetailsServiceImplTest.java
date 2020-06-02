package com.tracking.service.user;

import com.tracking.model.registration.AppUser;
import com.tracking.repository.user.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceImplTest {

    @Mock
    private UserRepository repository;

    private UserDetailsService userDetailsService;
    AppUser appUser = new AppUser();

    private UserDetails user;

    @Before
    public void setUp() throws Exception {

        userDetailsService = new UserDetailsServiceImpl(repository);
        appUser.setUsername("minato");

        user = appUser;

        Mockito.when(repository.findByField("username", "minato")).thenReturn(appUser);
    }

    @Test
    public void testLoadUserByUsername() {
        UserDetails userDetails = userDetailsService.loadUserByUsername("minato");
        assertEquals(user, userDetails);
    }
}