package com.seevrantillan.safespace.controller;

import com.seevrantillan.safespace.entity.UserEntity;
import com.seevrantillan.safespace.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity UserEntity) {
        return service.createUser(UserEntity);
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return service.getAllUsers();
    }

    @PutMapping("/{userID}")
    public UserEntity updateUserDetails(@PathVariable int userID, @RequestBody UserEntity userDetails) {
        return service.updateUser(userID, userDetails);
    }
}