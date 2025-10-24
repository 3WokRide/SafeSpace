package com.seevrantillan.safespace.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "learner")
public class LearnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long learnerId;

    private LocalDate enrollmentDate;
    private String status;

    @OneToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID", unique = true)
    private UserEntity user;

    public LearnerEntity() {
    }

    public LearnerEntity(LocalDate enrollmentDate, String status, UserEntity user) {
        this.enrollmentDate = enrollmentDate;
        this.status = status;
        this.user = user;
    }

    public Long getLearnerId() {
        return learnerId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    
}
