package com.seevrantillan.safespace.controller;

import com.seevrantillan.safespace.entity.UserEntity;
import com.seevrantillan.safespace.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/createUser")
    public UserEntity createUser(@RequestBody UserEntity UserEntity) {
        return service.saveUser(UserEntity);
    }

    @GetMapping("/getAllUsers")
    public List<UserEntity> getAllUsers() {
        return service.getAllUsers();
    }

    @PutMapping("/updateUser/{userID}")
    public UserEntity updateUserDetails(@PathVariable int userID, @RequestBody UserEntity userDetails) {
        return service.updateUser(userID, userDetails);
    }
}