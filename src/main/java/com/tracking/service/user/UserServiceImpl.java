package com.tracking.service.user;

import com.tracking.model.registration.AppUser;
import com.tracking.model.registration.Role;
import com.tracking.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleService roleService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public AppUser findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void addRoleToUser(AppUser userFromDb, Role roleFromDb) {
        userFromDb.getRoles().add(roleFromDb);
        userRepository.save(userFromDb);
    }

    @Override
    public void removeRoleFromUser(AppUser userFromDb, Role roleFromDb) {
        userFromDb.getRoles().remove(roleFromDb);
        userRepository.save(userFromDb);
    }

    @Override
    @Transactional
    public Map<String, String> save(AppUser user) {
        Map<String, String> exceptionAttribute = new HashMap<>();
        AppUser fromDb = userRepository.findByField("username", user.getUsername());
        if (fromDb != null) {
            exceptionAttribute.put("username", "Пользователь с таким именем уже существует");
        }
        AppUser fromDBByEmail = userRepository.findByField("email", user.getEmail());
        if (fromDBByEmail != null) {
            exceptionAttribute.put("email", "Пользователь с таким email уже существует");
        }
        AppUser fromDbByPhone = userRepository.findByField("phoneNumber", user.getPhoneNumber());
        if (fromDbByPhone != null) {
            exceptionAttribute.put("phoneNumber", "Пользователь с таким номером телефона уже существует");
        }
        if (exceptionAttribute.size() == 0) {
            processRoles(user);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
        return exceptionAttribute;
    }

    @Override
    @Transactional
    public void update(AppUser appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        userRepository.save(appUser);
    }

    private void processRoles(AppUser user) {
        if (user.getRoles().size() == 0) {
            Role userRole = roleService.findByName("ROLE_USER");
            user.setRoles(Collections.singleton(userRole));
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


}
