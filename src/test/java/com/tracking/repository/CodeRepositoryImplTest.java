package com.tracking.repository;

import com.tracking.config.HibernateConfig;
import com.tracking.config.WebConfig;
import com.tracking.model.tabel.Code;
import com.tracking.repository.tabel.CodeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateConfig.class, WebConfig.class})
@WebAppConfiguration
@Transactional
public class CodeRepositoryImplTest {

    @Resource
    private CodeRepository codeRepository;

    private Code code;

    @Before
    public void setUp() throws Exception {
        code = new Code();
        code.setCharCode("Н");
        code.setDescription("Отсутствие на рабочем месте по невыясненной причине");
    }

    @Test
    public void testFindCodeById() {
        codeRepository.save(code);
        Code codeFromDb = codeRepository.findAll().get(0);
        Code codeById = codeRepository.findById(codeFromDb.getId());
        assertEquals(code,codeById);
    }

    @Test
    public void testSaveCode() {
        codeRepository.save(code);
        List<Code> all = codeRepository.findAll();
        assertEquals(1,all.size());
    }

    @Test
    public void testDeleteCodeById() {
        codeRepository.save(code);
        Code code = codeRepository.findAll().get(0);
        codeRepository.deleteById(code.getId());
        List<Code> all = codeRepository.findAll();
        assertEquals(0,all.size());
    }

    @Test
    public void testFindAll() {
        codeRepository.save(code);
        List<Code> all = codeRepository.findAll();
        assertEquals(1,all.size());
    }
}