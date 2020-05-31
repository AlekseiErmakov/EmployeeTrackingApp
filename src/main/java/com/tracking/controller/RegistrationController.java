package com.tracking.controller;

import com.tracking.dto.UserDto;
import com.tracking.mapper.UserMapper;
import com.tracking.model.registration.AppUser;
import com.tracking.model.registration.Role;
import com.tracking.service.user.RoleService;
import com.tracking.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class RegistrationController {

    private UserService userService;

    private UserMapper userMapper;

    private RoleService roleService;

    @Autowired
    public RegistrationController(UserService userService, UserMapper userMapper, RoleService roleService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.roleService = roleService;
    }

    @GetMapping("/main")
    public String start() {
        return "redirect:/";
    }

    @GetMapping("/registration")
    public String getRegFrom(UserDto userDto) {
        return "registration";
    }

    @PostMapping("/registration")
    public String regUser(@ModelAttribute("userDto") @Valid UserDto userDto,
                          BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!isSame(userDto.getPassword(), userDto.getPasswordConfirmed())) {
            model.addAttribute("passwordConfirmed", "Введенные пароли не совпадают");
            return "registration";
        }
        if (!isSame(userDto.getEmail(), userDto.getEmailConfirmed())) {
            model.addAttribute("emailConfirmed", "Введенные пароли не совпадают");
            return "registration";
        }

        AppUser user = userMapper.toEntity(userDto);
        Map<String, String> errors = userService.save(user);
        if (errors.size() > 0) {
            errors.keySet().forEach(key -> model.addAttribute(key, errors.get(key)));
            return "registration";
        }
        return "redirect:/";
    }

    @ModelAttribute("roles")
    public List<Role> getRoles() {
        return roleService.findAll();
    }

    private boolean isSame(String password, String passwordConfirmed) {
        return password.equals(passwordConfirmed);
    }
}
