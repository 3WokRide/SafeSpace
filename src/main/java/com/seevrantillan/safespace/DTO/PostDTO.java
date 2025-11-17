package com.seevrantillan.safespace.DTO;

import com.seevrantillan.safespace.entity.PostEntity;

public class PostDTO {
    private int postID;
    private String content;
    private boolean isAnonymous;
    private int userID;
    private String userName;
    
    public PostDTO(PostEntity post) {
        this.postID = post.getPostID();
        this.content = post.getContent();
        this.isAnonymous = post.isAnonymous();
        
        if (post.getUser() != null) {
            this.userID = post.getUser().getUserID();
            this.userName = post.getUser().getUsername();
        } else {
             this.userID = 0; 
             this.userName = "Anonymous/Deleted";
        }
    }

    
    public int getPostID() {
        return postID;
    }

    public String getContent() {
        return content;
    }
    
    public boolean isAnonymous() {
        return isAnonymous;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

}