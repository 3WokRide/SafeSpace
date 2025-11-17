package com.seevrantillan.safespace.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.seevrantillan.safespace.entity.PostEntity;
import com.seevrantillan.safespace.entity.UserEntity;
import com.seevrantillan.safespace.repository.PostRepository;
import com.seevrantillan.safespace.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class PostService {

    private final PostRepository repository;
    private final UserRepository userRepository;

    public PostService(PostRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    // CREATE post using full entity
    public PostEntity createPost(PostEntity post) {
        post.setDate(LocalDateTime.now());
        return repository.save(post);
    }

    // CREATE post for a specific user
    public PostEntity createPostForUser(int userID, String content, boolean isAnonymous) {
        UserEntity user = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userID));

        PostEntity post = new PostEntity();
        post.setUser(user);
        post.setContent(content);
        post.setAnonymous(isAnonymous);
        post.setDate(LocalDateTime.now());
        post.setUpvotes(0);
        post.setDownvotes(0);

        return repository.save(post);
    }

    // READ post by ID
    public PostEntity findPostById(int postID) {
        return repository.findById(postID).orElseThrow();
    }

    // READ all posts
    public List<PostEntity> findAllPosts() {
        return repository.findAll();
    }

    // UPDATE post content, votes, or anonymous flag
    @Transactional
    public PostEntity updatePost(int postID, PostEntity updatedPost) {
        PostEntity existingPost = repository.findById(postID).orElseThrow();
        existingPost.setContent(updatedPost.getContent());
        existingPost.setUpvotes(updatedPost.getUpvotes());
        existingPost.setDownvotes(updatedPost.getDownvotes());
        existingPost.setAnonymous(updatedPost.isAnonymous());
        existingPost.setDate(LocalDateTime.now());

        if (updatedPost.getUser() != null) {
            existingPost.setUser(updatedPost.getUser());
        }

        return repository.save(existingPost);
    }

    // UPDATE only votes
    @Transactional
    public PostEntity updateVotes(int postID, int upvotes, int downvotes) {
        PostEntity existingPost = repository.findById(postID).orElseThrow();
        existingPost.setUpvotes(upvotes);
        existingPost.setDownvotes(downvotes);
        return repository.save(existingPost);
    }

    // DELETE post
    public void deletePost(int postID) {
        repository.deleteById(postID);
    }
}
