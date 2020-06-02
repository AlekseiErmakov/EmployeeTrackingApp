package com.tracking.repository.tabel;

import com.tracking.model.tabel.Holiday;
import com.tracking.service.tabel.HolidayService;
import com.tracking.service.tabel.HolidayServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class HolidayRepositoryImplTest {

    @Mock
    private HolidayRepository holidayRepository;

    private HolidayService holidayService;

    private LocalDate start = LocalDate.of(2020,6,1);
    private LocalDate end = LocalDate.of(2020,6,30);

    private Holiday holidayOne;
    private Holiday holidayTwo;

    @Before
    public void setUp() throws Exception {

        holidayService = new HolidayServiceImpl(holidayRepository);

        holidayOne = new Holiday();
        holidayOne.setDate(LocalDate.of(2020,6,12));

        holidayTwo = new Holiday();
        holidayTwo.setDate(LocalDate.of(2020,6,13));

        Mockito.when(holidayRepository.findHolidaysByMonth(start,end)).thenReturn(Arrays.asList(holidayOne,holidayTwo));
    }

    @Test
    public void testFindHolidaysByMonth() {

        assertEquals(Arrays.asList(12,13),holidayService.getHolidayDatesByMonth(6));
    }
}