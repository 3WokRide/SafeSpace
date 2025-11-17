package com.seevrantillan.safespace.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
// Removed unused JsonIdentityInfo and ObjectIdGenerators imports

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class PostEntity {

    // --- Primary Key ---
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postID;

    // --- Basic Post Details ---
    @Column(nullable = false)
    private LocalDateTime date;

    @Column(length = 1024, nullable = false)
    private String content;

    @Column(nullable = false)
    private int upvotes = 0;

    @Column(nullable = false)
    private int downvotes = 0;

    @Column(nullable = false)
    private boolean isAnonymous = false;

    // --- Many-to-One Relationship (Post belongs to one User) ---
    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private UserEntity user;

    // --- One-to-Many Relationships (Children) ---
    // IMPORTANT: Add @JsonIgnore to prevent infinite recursion during JSON serialization.
    @JsonIgnore // <-- Added @JsonIgnore
    @OneToMany(mappedBy = "post")
    private List<CommentEntity> comments;

    @JsonIgnore // <-- Added @JsonIgnore
    @OneToMany(mappedBy = "post")
    private List<ReactionEntity> reactions;


    // --- Constructors ---
    
    // No-args constructor is required by JPA and Jackson
    public PostEntity() {
    }

    // All-args constructor (modified to remove postID as it's generated)
    public PostEntity(LocalDateTime date, String content, int upvotes, int downvotes,
                      boolean isAnonymous, UserEntity user) {
        // Removed this.postID = postID;
        this.date = date;
        this.content = content;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.isAnonymous = isAnonymous;
        this.user = user;
    }

    // --- Getters and Setters ---

    // Getter for postID (No public setter for generated ID is generally preferred)
    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
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

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public List<ReactionEntity> getReactions() {
        return reactions;
    }

    public void setReactions(List<ReactionEntity> reactions) {
        this.reactions = reactions;
    }
}