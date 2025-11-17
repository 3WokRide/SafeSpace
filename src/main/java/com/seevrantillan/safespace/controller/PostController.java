package com.seevrantillan.safespace.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seevrantillan.safespace.DTO.PostDTO;
import com.seevrantillan.safespace.entity.PostEntity;
import com.seevrantillan.safespace.entity.UserEntity;
import com.seevrantillan.safespace.service.PostService;
import com.seevrantillan.safespace.service.UserService;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService service;
    private final UserService userService;

    public PostController(PostService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    // --- CREATE post using full entity ---
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PostEntity createPost(@RequestBody PostEntity post) {
        return service.createPost(post);
    }

    @PostMapping(value = "/createForUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PostDTO createPostForUser(@RequestBody PostEntity post) {
        if (post.getUser() == null) {
            throw new IllegalArgumentException("Request body must include nested user with userID");
        }
        int userId = post.getUser().getUserID();
        UserEntity user = userService.getUserById(userId);
        if (user == null) {
            throw new RuntimeException("User not found with ID: " + userId);
        }
        post.setUser(user);
        PostEntity savedPost = service.createPost(post);
        return new PostDTO(savedPost);
    }

    // --- GET all posts (Returns List of DTOs) ---
    @GetMapping
    public List<PostDTO> findAllPosts() {
        // Maps every PostEntity to a PostDTO
        return service.findAllPosts().stream()
                .map(PostDTO::new)
                .collect(Collectors.toList());
    }

    // --- GET post by ID (Returns DTO) ---
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findPostById(@PathVariable int id) {
        PostEntity post = service.findPostById(id);
        
        // Handles 404 Not Found
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Converts entity to DTO before returning
        return ResponseEntity.ok(new PostDTO(post));
    }

    // --- UPDATE post content, votes, or anonymous flag ---
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PostEntity updatePost(@PathVariable int id, @RequestBody PostEntity updatedPost) {
        // 🛠️ FIX: Ensure the ID from the URL path is the authoritative ID for the update.
        // This prevents the service from accidentally updating an entity specified by the 
        // ID in the request body, or creating a new entry if the service save logic is naive.
        updatedPost.setPostID(id); 
        
        return service.updatePost(id, updatedPost);
    }

    // --- UPDATE only votes ---
    @PutMapping("/{id}/votes")
    public PostEntity updateVotes(
            @PathVariable int id,
            @RequestParam int upvotes,
            @RequestParam int downvotes) {
        return service.updateVotes(id, upvotes, downvotes);
    }

    // --- DELETE post ---
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable int id) {
        service.deletePost(id);
        return "Post with ID " + id + " has been deleted successfully.";
    }
}