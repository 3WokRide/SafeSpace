package com.seevrantillan.safespace.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ModuleDTO {

    @NotNull(message = "User ID is required to associate the module with a user.")
    private Integer userID;
    
    @NotNull(message = "Title is required.")
    @Size(min = 1, max = 255, message = "Title must be between 1 and 255 characters.")
    private String title;

    @Size(max = 2048, message = "Description cannot exceed 2048 characters.") 
    private String description;

    public ModuleDTO() {}
    
    // --- Getters and Setters ---

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}