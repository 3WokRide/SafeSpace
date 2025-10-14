package com.seevrantillan.safespace.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seevrantillan.safespace.entity.CommentEntity;
import com.seevrantillan.safespace.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private final CommentRepository repo;

    public CommentService(CommentRepository repo) {
        this.repo = repo;
    }

    public CommentEntity saveComment(CommentEntity comment) {
        // Automatically set the date when saving a new comment
        comment.setDate(LocalDateTime.now());
        return repo.save(comment);
    }

    public CommentEntity updateCommentContent(int commentId, String newContent) {
        CommentEntity existingEntity = repo.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("Comment not found with ID: " + commentId));

        existingEntity.setContent(newContent);
        existingEntity.setDate(LocalDateTime.now());
        
        return repo.save(existingEntity);
    }

    public CommentEntity updateVotes(int commentId, int upvotes, int downvotes) {
        CommentEntity existingEntity = repo.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("Comment not found with ID: " + commentId));

        existingEntity.setUpvotes(upvotes);
        existingEntity.setDownvotes(downvotes);

        return repo.save(existingEntity);
    }

    public List<CommentEntity> getAllComments() {
        return repo.findAll();
    }

    public CommentEntity getCommentById(int commentId) {
        return repo.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("Comment not found with ID: " + commentId));
    }

    public void deleteComment(int commentId) {
        if (!repo.existsById(commentId)) {
            throw new NoSuchElementException("Comment not found with ID: " + commentId);
        }
        repo.deleteById(commentId);
    }
}
