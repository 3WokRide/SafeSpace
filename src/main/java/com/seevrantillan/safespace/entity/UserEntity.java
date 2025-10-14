package com.seevrantillan.safespace.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
 
    @Column(length=32) 
    private String username;
 
    @Column(length=128)
    private String password;
 
    @Column(length=128)
    private String email;
 
    @Column(length=32) 
    private String gender;

    @Column
    private int age;

    @Column(length=32) 
    private String role;

    @Column(length=32) 
    private String privacySettings;

    public UserEntity() {
    }

    public UserEntity(int userID, String username, String password, String email, String gender, int age, String role,
            String privacySettings) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.role = role;
        this.privacySettings = privacySettings;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPrivacySettings() {
        return privacySettings;
    }

    public void setPrivacySettings(String privacySettings) {
        this.privacySettings = privacySettings;
    }

    
}
