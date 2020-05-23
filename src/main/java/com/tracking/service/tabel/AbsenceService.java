package com.tracking.service.tabel;

import com.tracking.model.tabel.Absence;

import java.util.List;

public interface AbsenceService {
    void save(Absence absence);
    void deleteById(Long id);
    Absence findById(Long id);
    List<Absence> findAll();
}
