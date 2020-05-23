package com.tracking.controller;

import com.tracking.model.registration.AppUser;
import com.tracking.model.registration.Role;
import com.tracking.service.user.RoleService;
import com.tracking.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/add_role/")
    public String addRole(@RequestParam("user_id") Long user_id,
                          @RequestParam("role_id") Long role_id) {
        AppUser userFromDb = userService.findById(user_id);
        Role roleFromDb = roleService.findById(role_id);
        userService.addRoleToUser(userFromDb, roleFromDb);
        return "redirect:/admin/list";
    }

    @GetMapping("/edit_user/{id}")
    public String editUser(@PathVariable("id") Long id, AppUser user){
        user.setId(id);
        userService.save(user);
        return "redirect:admin/list";
    }

    @GetMapping("/list")
    public String getEmployeeList() {
        return "user_list";
    }

    @GetMapping("/remove_role")
    public String removeRole(@RequestParam("user_id") Long user_id,
                             @RequestParam("role_id") Long role_id) {
        AppUser userFromDb = userService.findById(user_id);
        Role roleFromDb = roleService.findById(role_id);
        userService.removeRoleFromUser(userFromDb, roleFromDb);
        return "redirect:/admin/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin/list";
    }

    @ModelAttribute("users")
    public List<AppUser> getAppUsers() {
        return userService.findAll();
    }
}
