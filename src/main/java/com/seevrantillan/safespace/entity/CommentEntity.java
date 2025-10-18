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
    private int commentId;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(length = 512, nullable = false)
    private String content;

    @Column(nullable = false)
    private int upvotes;

    @Column(nullable = false)
    private int downvotes;

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

    public CommentEntity(int commentId, LocalDateTime date, String content, int upvotes, int downvotes,
                         UserEntity user /* , PostEntity post*/) {
        this.commentId = commentId;
        this.date = date;
        this.content = content;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.user = user;
        // this.post = post;
    }

    public int getCommentId() {
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

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    // public PostEntity getPost() {
    //     return post;
    // }

    // public void setPost(PostEntity post) {
    //     this.post = post;
    // }
}
