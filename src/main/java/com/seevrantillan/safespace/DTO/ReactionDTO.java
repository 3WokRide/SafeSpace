package com.seevrantillan.safespace.DTO;

public class ReactionDTO {
    private int userID;
    private Integer postID;
    private Integer commentID;
    private String reactionType;

    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }
    
    public Integer getPostID() { return postID; }
    public void setPostID(Integer postID) { this.postID = postID; }
    
    public Integer getCommentID() { return commentID; }
    public void setCommentID(Integer commentID) { this.commentID = commentID; }
    
    public String getReactionType() { return reactionType; }
    public void setReactionType(String reactionType) { this.reactionType = reactionType; }
}
