package com.tracking.service.tabel;

import com.tracking.model.tabel.Holiday;
import com.tracking.repository.tabel.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidayServiceImpl implements HolidayService {

    private HolidayRepository holidayRepository;

    @Autowired
    public HolidayServiceImpl(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Override
    @Transactional
    public List<Integer> getHolidayDatesByMonth(int month) {
        LocalDate start = getStartDate(month);
        LocalDate end = getMonthEndDateDate(start);
        List<Holiday> holidaysByMonth = holidayRepository.findHolidaysByMonth(start, end);
        return holidaysByMonth.stream()
                .map(holiday -> holiday.getDate().getDayOfMonth())
                .collect(Collectors.toList());
    }

    private LocalDate getStartDate(int month) {
        LocalDate now = LocalDate.now();
        return LocalDate.of(now.getYear(), month, 1);
    }

    private LocalDate getMonthEndDateDate(LocalDate start) {
        return LocalDate.of(start.getYear(), start.getMonth(), start.getMonth().length(start.isLeapYear()));
    }
}
