package com.tracking.service.tabel;

import com.tracking.model.tabel.Code;
import com.tracking.repository.tabel.CodeRepository;
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
    public List<Code> findAll() {
        return codeRepository.findAll();
    }

    @Override
    @Transactional
    public Code findById(Long codeid) {
        return codeRepository.findById(codeid);
    }
}
