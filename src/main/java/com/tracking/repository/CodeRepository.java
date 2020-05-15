package com.tracking.repository;

import com.tracking.model.Code;

import java.util.List;

public interface CodeRepository {
    Code findCodeById(Long id);
    void saveCode(Code code);
    void deleteCodeById(Long id);
    List<Code> findAll();
}
