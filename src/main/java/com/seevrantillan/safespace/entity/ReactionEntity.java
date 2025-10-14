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
    private int reactionId;

    @Column(length = 50, nullable = false)
    private String targetType; // e.g., "Post" or "Comment"

    @Column(nullable = false)
    private int targetID;

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

    public ReactionEntity() {
    }

    public ReactionEntity(int reactionId, String targetType, int targetID, String reactionType, 
                          UserEntity user, /*PostEntity post,*/ CommentEntity comment) {
        this.reactionId = reactionId;
        this.targetType = targetType;
        this.targetID = targetID;
        this.reactionType = reactionType;
        this.user = user;
        // this.post = post;
        this.comment = comment;
    }

    public int getReactionId() {
        return reactionId;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public int getTargetID() {
        return targetID;
    }

    public void setTargetID(int targetID) {
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

    // public PostEntity getPost() {
    //     return post;
    // }

    // public void setPost(PostEntity post) {
    //     this.post = post;
    // }

    // public CommentEntity getComment() {
    //     return comment;
    // }

    // public void setComment(CommentEntity comment) {
    //     this.comment = comment;
    // }
}
