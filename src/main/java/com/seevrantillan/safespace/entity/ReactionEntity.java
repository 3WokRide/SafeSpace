package com.seevrantillan.safespace.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn; // New import
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reaction")
public class ReactionEntity {

    // --- Primary Key ---
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reactionId;

    @Column(length = 50, nullable = false)
    private String reactionType; 

    // --- Relationships (Many-to-One) ---
    // CRITICAL FIX: Use @JoinColumn to match the database column names (e.g., 'userid').
    // Use @JsonIgnore to prevent infinite recursion during JSON serialization.

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false) // Assumes database column is named 'userid'
    @JsonIgnore 
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "postid") // Assumes database column is named 'postid'
    @JsonIgnore 
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "commentid") // Assumes database column is named 'commentid'
    @JsonIgnore 
    private CommentEntity comment;


    // --- Constructors ---
    
    // No-args constructor required by JPA and Jackson
    public ReactionEntity() {
    }

    // All-args constructor for service creation (excluding generated ID)
    public ReactionEntity(String reactionType, UserEntity user, PostEntity post, CommentEntity comment) {
        this.reactionType = reactionType;
        this.user = user;
        this.post = post;
        this.comment = comment;
    }

    // --- Getters and Setters ---

    public int getReactionId() {
        return reactionId;
    }
    
    public void setReactionId(int reactionId) {
        this.reactionId = reactionId;
    }

    public String getReactionType() {
        return reactionType;
    }

    public void setReactionType(String reactionType) {
        this.reactionType = reactionType;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public CommentEntity getComment() {
        return comment;
    }

    public void setComment(CommentEntity comment) {
        this.comment = comment;
    }
}