package com.tracking.repository;

import com.tracking.model.Code;

import java.util.List;

public interface CodeRepository {
    Code findById(Long id);
    void save(Code code);
    void deleteById(Long id);
    List<Code> findAll();
}
