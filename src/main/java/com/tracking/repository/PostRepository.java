package com.tracking.repository;

import com.tracking.model.Post;

import java.util.List;

public interface PostRepository {
    void save(Post post);
    void deleteById(Long id);
    Post findById(Long id);
    List<Post> findAll();
}
