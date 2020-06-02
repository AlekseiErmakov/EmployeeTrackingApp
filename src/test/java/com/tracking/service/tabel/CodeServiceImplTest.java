package com.tracking.service.tabel;

import com.tracking.model.tabel.Code;
import com.tracking.repository.tabel.CodeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CodeServiceImplTest {

    @Mock
    private CodeRepository repository;

    private CodeService codeService;

    private Code illness;

    private Code absence;


    @Before
    public void setUp() throws Exception {
        codeService = new CodeServiceImpl(repository);

        illness = new Code();
        illness.setId(1L);
        illness.setStatus("Il");

        absence = new Code();
        absence.setId(2L);
        absence.setStatus("Ab");


        Mockito.when(repository.findById(1L)).thenReturn(illness);
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(illness, absence));
    }

    @Test
    public void findAll() {
        assertEquals(Arrays.asList(illness, absence), codeService.findAll());
    }

    @Test
    public void findById() {

        assertEquals(illness, codeService.findById(1L));
    }
}