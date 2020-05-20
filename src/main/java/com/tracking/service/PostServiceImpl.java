package com.tracking.service;

import com.tracking.model.employee.Post;
import com.tracking.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    @Transactional
    public void save(Post post) {
        this.postRepository.save(post);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.postRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Post findById(Long id) {
        return this.postRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
