package com.tracking.service;

import com.tracking.model.employee.Post;

import java.util.List;

public interface PostService {
    void save(Post post);
    void deleteById(Long id);
    Post findById(Long id);
    List<Post> findAll();
}
