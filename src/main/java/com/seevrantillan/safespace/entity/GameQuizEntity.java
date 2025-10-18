package com.seevrantillan.safespace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gamequizzes")
public class GameQuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;
    private String title;
    private Integer score;
    private String type;

    public GameQuizEntity() {
    }

    public GameQuizEntity(String title, Integer score, String type) {
        this.title = title;
        this.score = score;
        this.type = type;
    }

    public Long getGameId() {
        return gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
