package com.seevrantillan.safespace.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(length = 32, nullable = false, unique = true)
    private String username;

    @Column(length = 128, nullable = false)
    private String password;

    @Column(length = 128, nullable = false, unique = true)
    private String email;

    @Column(length = 32, nullable = false)
    private String gender;

    @Column
    private Integer age;

    @Column(length = 32)
    private String privacySettings;

    @Column(nullable = false)
    private Character userType;

    public UserEntity() {
    }
    
    public UserEntity(String username, String password, String email, String gender, Integer age,
            String privacySettings, Character userType) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.privacySettings = privacySettings;
        this.userType = userType;
    }

    public Long getUserID() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPrivacySettings() {
        return privacySettings;
    }

    public void setPrivacySettings(String privacySettings) {
        this.privacySettings = privacySettings;
    }

    public Character getUserType() {
        return userType;
    }

    public void setUserType(Character userType) {
        this.userType = userType;
    }

    
}
