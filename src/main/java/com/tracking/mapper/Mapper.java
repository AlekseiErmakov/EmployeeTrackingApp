package com.tracking.mapper;

import com.tracking.dto.AbstractDto;
import com.tracking.model.tabel.AbstractEntity;

public interface Mapper<E extends AbstractEntity,D extends AbstractDto> {
    E toEntity(D dto);
    D toDto(E entity);
}
