package com.tracking.service.employee;

import com.tracking.model.employee.Post;
import com.tracking.repository.employee.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceImplTest {

    @Mock
    private PostRepository repository;

    private PostService postService;

    private Post javaDev;

    private Post javaScriptDev;

    @Before
    public void setUp() throws Exception {
        postService = new PostServiceImpl(repository);

        javaDev = new Post();
        javaDev.setId(1L);
        javaDev.setName("Java developer");

        javaScriptDev = new Post();
        javaScriptDev.setName("JavaScript developer");
        javaScriptDev.setId(2L);

        Mockito.when(repository.findById(1L)).thenReturn(javaDev);
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(javaDev, javaScriptDev));
    }


    @Test
    public void testFindById() {

        assertEquals(javaDev, postService.findById(1L));
    }

    @Test
    public void testFindAll() {
        assertEquals(Arrays.asList(javaDev, javaScriptDev), postService.findAll());
    }
}