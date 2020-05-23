package com.tracking.mapper;

import com.tracking.dto.UserDto;
import com.tracking.model.registration.AppUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserMapper extends AbstractMapper<AppUser, UserDto> {


    private ModelMapper modelMapper;

    @Autowired
    public UserMapper(ModelMapper modelMapper) {
        super(AppUser.class, UserDto.class, modelMapper);
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void initMapper(){
        modelMapper.createTypeMap(AppUser.class, UserDto.class)
                .setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(UserDto.class,AppUser.class)
                .setPostConverter(toEntityConverter());
    }

}
