package com.tracking.service;

import com.tracking.model.Code;

import java.util.List;

public interface CodeService {
    Code findById(Long id);
    void save(Code code);
    void deleteById(Long id);
    List<Code> findAll();
}
