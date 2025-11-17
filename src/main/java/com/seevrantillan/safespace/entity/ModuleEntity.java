package com.seevrantillan.safespace.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "module")
public class ModuleEntity {

    // --- Primary Key ---
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moduleID; // Using Long for ID is standard practice in Java/JPA

    // --- Basic Details ---
    @Column(nullable = false)
    private String title;
    
    @Column(length = 2048) // Added length for description column
    private String description;
    
    @Column(nullable = false, updatable = false) // Ensures creation time isn't changed later
    private LocalDateTime createdAt;

    // --- Many-to-One Relationship (Module belongs to one User) ---
    // IMPORTANT: Add @JsonIgnore to prevent infinite recursion during JSON serialization.
    @ManyToOne
    @JoinColumn(name = "userID", nullable = false) // Explicitly map the foreign key column
    @JsonIgnore
    private UserEntity user;


    // --- Constructors ---

    // No-args constructor is required by JPA and Jackson
    public ModuleEntity() {
    }

    // All-args constructor for convenience (excluding the generated ID)
    public ModuleEntity(String title, String description, LocalDateTime createdAt, UserEntity user) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.user = user;
    }


    // --- Getters and Setters ---

    public Long getModuleID() {
        return moduleID;
    }

    public void setModuleID(Long moduleID) {
        this.moduleID = moduleID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}