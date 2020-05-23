package com.tracking.service.user;

import com.tracking.model.registration.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);
    void deleteById(Long id);
    Role findById(Long id);
    List<Role> findAll();
}
