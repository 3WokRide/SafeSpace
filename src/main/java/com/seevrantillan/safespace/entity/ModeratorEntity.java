package com.seevrantillan.safespace.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "moderator")
public class ModeratorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modId;

    private LocalDateTime dateAssigned;
    private Integer moderationLevel;

    @OneToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID", unique = true)
    private UserEntity user;

    public ModeratorEntity(LocalDateTime dateAssigned, Integer moderationLevel, UserEntity user) {
        this.dateAssigned = dateAssigned;
        this.moderationLevel = moderationLevel;
        this.user = user;
    }

    public Long getModId() {
        return modId;
    }

    public LocalDateTime getDateAssigned() {
        return dateAssigned;
    }

    public void setDateAssigned(LocalDateTime dateAssigned) {
        this.dateAssigned = dateAssigned;
    }

    public Integer getModerationLevel() {
        return moderationLevel;
    }

    public void setModerationLevel(Integer moderationLevel) {
        this.moderationLevel = moderationLevel;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    
}
