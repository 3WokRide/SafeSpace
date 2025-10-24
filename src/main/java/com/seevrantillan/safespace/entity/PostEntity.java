package com.seevrantillan.safespace.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private LocalDateTime date;
    private String content;
    private Integer upvotes;
    private Integer downvotes;
    private Boolean isAnonymous;

    public PostEntity() {
    }
    
    public PostEntity(LocalDateTime date, String content, Integer upvotes, Integer downvotes, Boolean isAnonymous) {
        this.date = date;
        this.content = content;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.isAnonymous = isAnonymous;
    }

    public Long getPostId() {
        return postId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public Integer getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(Integer downvotes) {
        this.downvotes = downvotes;
    }

    public Boolean getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    
}
