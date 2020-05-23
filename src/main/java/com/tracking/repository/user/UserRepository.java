package com.tracking.repository.user;

import com.tracking.model.registration.AppUser;

import java.util.List;

public interface UserRepository {
    AppUser findById(Long id);
    void save(AppUser appUser);
    void deleteById(Long id);
    List<AppUser> findAll();
    AppUser findByField(String field, String value);
}
