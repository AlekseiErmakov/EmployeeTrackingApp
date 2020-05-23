package com.tracking.service.user;

import com.tracking.model.registration.AppUser;
import com.tracking.model.registration.Role;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String, String> save(AppUser absence);
    void deleteById(Long id);
    AppUser findById(Long id);
    List<AppUser> findAll();
    void addRoleToUser(AppUser userFromDb, Role roleFromDb);
    void removeRoleFromUser(AppUser userFromDb, Role roleFromDb);
}
