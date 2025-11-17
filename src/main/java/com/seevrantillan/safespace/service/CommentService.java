package com.seevrantillan.safespace.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.seevrantillan.safespace.entity.CommentEntity;
import com.seevrantillan.safespace.entity.PostEntity;
import com.seevrantillan.safespace.entity.UserEntity;
import com.seevrantillan.safespace.repository.CommentRepository;
import com.seevrantillan.safespace.repository.PostRepository;
import com.seevrantillan.safespace.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class CommentService {

    private final CommentRepository repository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository repository, UserRepository userRepository, PostRepository postRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    // CREATE comment
    public CommentEntity createComment(CommentEntity comment) {
        comment.setDate(LocalDateTime.now());
        return repository.save(comment);
    }

    // CREATE comment for specific user + post
    public CommentEntity createCommentForUserPost(int userID, int postID, String content) {
        UserEntity user = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userID));
        PostEntity post = postRepository.findById((int) postID)
                .orElseThrow(() -> new RuntimeException("Post not found with ID: " + postID));

        CommentEntity comment = new CommentEntity();
        comment.setUser(user);
        comment.setPost(post);
        comment.setContent(content);
        comment.setDate(LocalDateTime.now());
        comment.setUpvotes(0);
        comment.setDownvotes(0);

        return repository.save(comment);
    }


    // READ comment by ID
    public CommentEntity findCommentById(int id) {
        return repository.findById(id).orElseThrow();
    }

    // READ all comments
    public List<CommentEntity> findAllComments() {
        return repository.findAll();
    }

    // UPDATE comment content and user/post association
    @Transactional
    public CommentEntity updateComment(int id, CommentEntity updatedComment) {
        CommentEntity existingComment = repository.findById(id).orElseThrow();
        existingComment.setContent(updatedComment.getContent());
        existingComment.setUpvotes(updatedComment.getUpvotes());
        existingComment.setDownvotes(updatedComment.getDownvotes());
        existingComment.setDate(LocalDateTime.now());

        if (updatedComment.getUser() != null) {
            existingComment.setUser(updatedComment.getUser());
        }
        if (updatedComment.getPost() != null) {
            existingComment.setPost(updatedComment.getPost());
        }

        return repository.save(existingComment);
    }

    // UPDATE only votes
    @Transactional
    public CommentEntity updateVotes(int id, int upvotes, int downvotes) {
        CommentEntity existingComment = repository.findById(id).orElseThrow();
        existingComment.setUpvotes(upvotes);
        existingComment.setDownvotes(downvotes);
        return repository.save(existingComment);
    }

    // DELETE comment
    public void deleteComment(int id) {
        repository.deleteById(id);
    }
}
