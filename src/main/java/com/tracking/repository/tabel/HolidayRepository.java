package com.tracking.repository.tabel;

import com.tracking.model.tabel.Holiday;

import java.time.LocalDate;
import java.util.List;

public interface HolidayRepository {
    List<Holiday> findHolidaysByMonth(LocalDate start, LocalDate end);
}
