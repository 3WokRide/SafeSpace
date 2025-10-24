package com.seevrantillan.safespace.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(length = 512, nullable = false)
    private String content;

    @Column(nullable = false)
    private Integer upvotes;

    @Column(nullable = false)
    private Integer downvotes;

    // Each comment belongs to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false)
    private UserEntity user;

    // // Each comment belongs to one post
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "postID", nullable = false)
    // private PostEntity post;

    public CommentEntity() {
    }

    public CommentEntity(LocalDateTime date, String content, Integer upvotes, Integer downvotes, UserEntity user) {
        this.date = date;
        this.content = content;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.user = user;
    }

    public Long getCommentId() {
        return commentId;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
