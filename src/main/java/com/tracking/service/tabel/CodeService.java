package com.tracking.service.tabel;

import com.tracking.model.tabel.Code;

import java.util.List;

public interface CodeService {
    List<Code> findAll();

    Code findById(Long codeid);
}

