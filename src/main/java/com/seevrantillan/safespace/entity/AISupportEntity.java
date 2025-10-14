package com.seevrantillan.safespace.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "aisupport")
public class AISupportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aiID;
 
    @Column(length=512) 
    private String question;

    @Column
    LocalDateTime timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false)
    private UserEntity user;

    public AISupportEntity() {
    }

    public AISupportEntity(int aiID, String question, LocalDateTime timestamp, UserEntity user) {
        this.aiID = aiID;
        this.question = question;
        this.timestamp = timestamp;
        this.user = user;
    }

    public int getAiID() {
        return aiID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    } 
}