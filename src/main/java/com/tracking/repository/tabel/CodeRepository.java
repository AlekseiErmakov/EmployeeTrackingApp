package com.tracking.repository.tabel;

import com.tracking.model.tabel.Code;

import java.util.List;

public interface CodeRepository {
    List<Code> findAll();

    Code findById(Long codeid);
}
