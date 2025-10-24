package com.seevrantillan.safespace.service;

import com.seevrantillan.safespace.entity.UserEntity;
import com.seevrantillan.safespace.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public UserEntity createUser(UserEntity User) {
        return repo.save(User);
    }

    public List<UserEntity> getAllUsers() {
        return repo.findAll();
    }

    public UserEntity getUserById(long userID) {
        return repo.findById(userID).orElseThrow(() -> new NoSuchElementException("User not found with ID: " + userID));
    }

    public UserEntity updateUser(long userID, UserEntity userDetails) {
        UserEntity existingUser = repo.findById(userID)
                .orElseThrow(() -> new NoSuchElementException("User not found with ID: " + userID));

        existingUser.setUsername(userDetails.getUsername());
        existingUser.setPassword(userDetails.getPassword());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setGender(userDetails.getGender());
        existingUser.setAge(userDetails.getAge());
        existingUser.setPrivacySettings(userDetails.getPrivacySettings());

        return repo.save(existingUser);
    }
}
