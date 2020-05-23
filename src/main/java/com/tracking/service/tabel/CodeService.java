package com.tracking.service.tabel;

import com.tracking.model.tabel.Code;

import java.util.List;

public interface CodeService {
    Code findById(Long id);
    void save(Code code);
    void deleteById(Long id);
    List<Code> findAll();
}
