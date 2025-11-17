

package com.seevrantillan.safespace.DTO;

public class CommentDTO {

    private int userID;
    private int postID;
    private String content;

    public CommentDTO() {
    }

    public CommentDTO(int userID, int postID, String content) {
        this.userID = userID;
        this.postID = postID;
        this.content = content;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
