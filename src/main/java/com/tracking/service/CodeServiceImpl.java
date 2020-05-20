package com.tracking.service;

import com.tracking.model.tabel.Code;
import com.tracking.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CodeServiceImpl implements CodeService {


    private CodeRepository codeRepository;

    @Autowired
    public CodeServiceImpl(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @Override
    @Transactional
    public Code findById(Long id) {
        return this.codeRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(Code code) {
        this.codeRepository.save(code);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.codeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Code> findAll() {
        return this.codeRepository.findAll();
    }
}
