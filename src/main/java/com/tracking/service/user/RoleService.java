package com.tracking.service.user;

import com.tracking.model.registration.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);

    void deleteById(Long id);

    Role findById(Long id);

    Role findByName(String roleName);

    List<Role> findAll();
}
