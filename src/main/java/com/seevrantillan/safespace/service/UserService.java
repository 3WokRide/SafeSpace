package com.seevrantillan.safespace.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seevrantillan.safespace.entity.UserEntity;
import com.seevrantillan.safespace.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public UserEntity saveUser(UserEntity user) {
        return repo.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return repo.findAll();
    }

    public UserEntity updateUser(int userID, UserEntity userDetails) {
        UserEntity existingUser = repo.findById(userID)
            .orElseThrow(() -> new NoSuchElementException(
                "User not found with ID: " + userID));

        existingUser.setUsername(userDetails.getUsername());
        existingUser.setPassword(userDetails.getPassword());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setGender(userDetails.getGender());
        existingUser.setAge(userDetails.getAge());
        existingUser.setRole(userDetails.getRole());
        existingUser.setPrivacySettings(userDetails.getPrivacySettings());
        existingUser.setUserType(userDetails.getUserType());

        return repo.save(existingUser);
    }
    public UserEntity getUserById(int userID) {
    return repo.findById(userID)
            .orElseThrow(() -> new NoSuchElementException("User not found with ID: " + userID));
    }

    public void deleteUser(int userID) {
    repo.deleteById(userID);
    }

}
