package com.tracking.mapper;

import com.tracking.dto.AbstractDto;
import com.tracking.model.tabel.AbstractEntity;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import java.util.Objects;


public class AbstractMapper<E extends AbstractEntity, D extends AbstractDto> implements Mapper<E, D> {

    private ModelMapper modelMapper;

    private Class<E> entityClass;

    private Class<D> dtoClass;

    public AbstractMapper(Class<E> entityClass, Class<D> dtoClass, ModelMapper modelMapper) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
        this.modelMapper = modelMapper;

    }

    @Override
    public E toEntity(D dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, entityClass);
    }

    @Override
    public D toDto(E entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, dtoClass);
    }
    Converter<E,D> toDtoConverter(){
        return mappingContext -> {
            E source = mappingContext.getSource();
            D destination = mappingContext.getDestination();
            mapSpecificFields(source,destination);
            return mappingContext.getDestination();
        };
    }
    Converter<D,E> toEntityConverter(){
        return mappingContext -> {
            D source = mappingContext.getSource();
            E destination = mappingContext.getDestination();
            mapSpecificFields(source,destination);
            return mappingContext.getDestination();
        };
    }

    protected void mapSpecificFields(E source, D destination){

    }
    protected void mapSpecificFields(D source, E destination){

    }
}
