package com.tracking.service;

import com.tracking.model.Absence;
import com.tracking.repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AbsenceServiceImpl implements AbsenceService {

    private AbsenceRepository absenceRepository;

    @Autowired
    public AbsenceServiceImpl(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    @Override
    @Transactional
    public void save(Absence absence) {
        this.absenceRepository.save(absence);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.absenceRepository.deleteByID(id);
    }

    @Override
    @Transactional
    public Absence findById(Long id) {
        return this.absenceRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Absence> findAll() {
        return this.absenceRepository.findAll();
    }
}
