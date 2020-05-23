package com.tracking.repository.user;

import com.tracking.model.registration.Role;

import java.util.List;

public interface RoleRepository {
    Role findRoleByName(String name);
    void deleteById(Long id);
    void save(Role role);
    Role findById(Long id);
    List<Role> findAll();
}
