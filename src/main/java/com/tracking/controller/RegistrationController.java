package com.tracking.controller;

import com.tracking.dto.UserDto;
import com.tracking.mapper.UserMapper;
import com.tracking.model.registration.AppUser;
import com.tracking.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {

    private UserService userService;

    private UserMapper userMapper;

    @Autowired
    public RegistrationController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping({"", "/"})
    public String start() {
        return "index";
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
        if (!isSame(userDto.getPassword(),userDto.getPasswordConfirmed())) {
            model.addAttribute("passwordConfirmed", "Введенные пароли не совпадают");
            return "registration";
        }
        if (!isSame(userDto.getEmail(),userDto.getEmailConfirmed())) {
            model.addAttribute("emailConfirmed", "Введенные пароли не совпадают");
            return "registration";
        }
        AppUser user = userMapper.toEntity(userDto);
        Map<String,String> errors = userService.save(user);
        if (errors.size()>0) {
            errors.keySet().forEach(key->model.addAttribute(key,errors.get(key)));
            return "registration";
        }
        return "redirect:/";
    }

    private boolean isSame(String password, String passwordConfirmed) {
        return password.equals(passwordConfirmed);
    }
}
