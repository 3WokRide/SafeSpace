package com.seevrantillan.safespace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "progress")
public class ProgressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progressId;
    private Integer score;
    private Integer badgesEarned;
    private Integer progressLevel;

    public ProgressEntity() {
    }

    public ProgressEntity(Integer score, Integer badgesEarned, Integer progressLevel) {
        this.score = score;
        this.badgesEarned = badgesEarned;
        this.progressLevel = progressLevel;
    }

    public Long getProgressId() {
        return progressId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getBadgesEarned() {
        return badgesEarned;
    }

    public void setBadgesEarned(Integer badgesEarned) {
        this.badgesEarned = badgesEarned;
    }

    public Integer getProgressLevel() {
        return progressLevel;
    }

    public void setProgressLevel(Integer progressLevel) {
        this.progressLevel = progressLevel;
    }

}
