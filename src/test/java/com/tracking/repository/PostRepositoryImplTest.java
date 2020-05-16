package com.tracking.repository;

import com.tracking.config.HibernateConfig;
import com.tracking.config.WebConfig;
import com.tracking.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateConfig.class, WebConfig.class})
@WebAppConfiguration
@Transactional
public class PostRepositoryImplTest {

    @Resource
    private PostRepository repository;

    private Post javaDev;

    @Before
    public void setUp() throws Exception {
        javaDev = new Post();
        javaDev.setName("java developer");
    }

    @Test
    public void save() {
        repository.save(javaDev);
        List<Post> all = repository.findAll();
        assertTrue( all.contains(javaDev));
    }

    @Test
    public void deleteById() {
        repository.save(javaDev);
        Post post = repository.findAll().get(0);
        Long id = post.getId();
        repository.deleteById(id);
        assertEquals(0,repository.findAll().size());
    }

    @Test
    public void findById() {
        repository.save(javaDev);
        Post post = repository.findAll().get(0);
        Long id = post.getId();
        assertEquals(javaDev,repository.findById(id));
    }

    @Test
    public void findAll() {
        repository.save(javaDev);
        List<Post> all = repository.findAll();
        assertEquals(1, all.size());
    }
}