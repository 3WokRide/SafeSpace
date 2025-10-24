package com.seevrantillan.safespace.entity;

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
@Table(name = "reaction")
public class ReactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reactionId;

    @Column(length = 50, nullable = false)
    private String targetType; // e.g., "Post" or "Comment"

    @Column(nullable = false)
    private Integer targetID;

    @Column(length = 50, nullable = false)
    private String reactionType; // e.g., "Like", "Love", "Haha"

    // Each reaction belongs to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false)
    private UserEntity user;

    // // A reaction can target either a Post or Comment
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "postID", nullable = true)
    // private PostEntity post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commentID", nullable = true)
    private CommentEntity comment;

    public ReactionEntity(String targetType, Integer targetID, String reactionType, UserEntity user,
            CommentEntity comment) {
        this.targetType = targetType;
        this.targetID = targetID;
        this.reactionType = reactionType;
        this.user = user;
        this.comment = comment;
    }

    public ReactionEntity() {
    }

    public Long getReactionId() {
        return reactionId;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public Integer getTargetID() {
        return targetID;
    }

    public void setTargetID(Integer targetID) {
        this.targetID = targetID;
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

    public CommentEntity getComment() {
        return comment;
    }

    public void setComment(CommentEntity comment) {
        this.comment = comment;
    }   
}
