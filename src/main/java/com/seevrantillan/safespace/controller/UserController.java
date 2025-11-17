package com.seevrantillan.safespace.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seevrantillan.safespace.entity.UserEntity;
import com.seevrantillan.safespace.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    // Use constructor injection for dependencies (which you already do, great!)
    public UserController(UserService service) {
        this.service = service;
    }

    // --- CREATE ---
    // Added 'consumes' to resolve 415 error and used ResponseEntity for 201 Created status
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        UserEntity savedUser = service.saveUser(userEntity);
        // Returns 201 CREATED status
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // --- READ ALL ---
    // Using ResponseEntity to return a clear 200 OK status
    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    // --- READ BY ID ---
    // Using ResponseEntity.ok() for 200 OK
    @GetMapping("/get/{userID}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable int userID) {
        UserEntity user = service.getUserById(userID);
        // Assuming service.getUserById handles the case where the user is not found,
        // otherwise, you should wrap it in an Optional and return 404 NOT_FOUND.
        return ResponseEntity.ok(user);
    }

    // --- UPDATE ---
    // Added 'consumes' to resolve 415 error.
    @PutMapping(value = "/update/{userID}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity> updateUserDetails(
            @PathVariable int userID,
            @RequestBody UserEntity userDetails) {
        UserEntity updatedUser = service.updateUser(userID, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    // --- DELETE ---
    // Using ResponseEntity to return 204 No Content status, which is standard for successful deletions.
    @DeleteMapping("/delete/{userID}")
    public ResponseEntity<String> deleteUser(@PathVariable int userID) {
        service.deleteUser(userID);
        // Returns 204 NO_CONTENT status
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User with ID " + userID + " has been deleted.");
    }
}