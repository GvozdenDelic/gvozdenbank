package com.fullstack.gvozdenbank.controllers;

import com.fullstack.gvozdenbank.dto.UserDTO;
import com.fullstack.gvozdenbank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createUser(@RequestBody UserDTO user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public ArrayList<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }
}