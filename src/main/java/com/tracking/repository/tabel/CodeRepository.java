package com.tracking.repository.tabel;

import com.tracking.model.tabel.Code;

import java.util.List;

public interface CodeRepository {
    Code findById(Long id);
    void save(Code code);
    void deleteById(Long id);
    List<Code> findAll();
}
