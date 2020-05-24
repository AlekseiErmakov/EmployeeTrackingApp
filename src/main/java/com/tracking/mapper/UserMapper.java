package com.tracking.mapper;

import com.tracking.dto.UserDto;
import com.tracking.model.registration.AppUser;
import com.tracking.model.registration.Role;
import com.tracking.service.user.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserMapper extends AbstractMapper<AppUser, UserDto> {

    private RoleService roleService;
    private ModelMapper modelMapper;

    @Autowired
    public UserMapper(RoleService roleService, ModelMapper modelMapper) {
        super(AppUser.class, UserDto.class, modelMapper);
        this.roleService = roleService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void initMapper(){
        modelMapper.createTypeMap(AppUser.class, UserDto.class)
                .setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(UserDto.class,AppUser.class)
                .setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(AppUser source, UserDto destination) {
        Set<Long> collect = source.getRoles().stream()
                .map(Role::getId)
                .collect(Collectors.toSet());
        destination.setRoleIdSet(collect);
    }

    @Override
    protected void mapSpecificFields(UserDto source, AppUser destination) {
        Set<Role> collect = source.getRoleIdSet().stream()
                .map(id -> roleService.findById(id))
                .collect(Collectors.toSet());
        destination.setRoles(collect);
    }
}
