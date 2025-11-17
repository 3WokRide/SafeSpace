package com.seevrantillan.safespace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seevrantillan.safespace.entity.CommentEntity;
import com.seevrantillan.safespace.entity.PostEntity;
import com.seevrantillan.safespace.entity.ReactionEntity;
import com.seevrantillan.safespace.entity.UserEntity;
import com.seevrantillan.safespace.repository.CommentRepository;
import com.seevrantillan.safespace.repository.PostRepository;
import com.seevrantillan.safespace.repository.ReactionRepository;
import com.seevrantillan.safespace.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class ReactionService {

    private final ReactionRepository repository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public ReactionService(ReactionRepository repository, UserRepository userRepository,
                           PostRepository postRepository, CommentRepository commentRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    // CREATE a reaction
    public ReactionEntity createReaction(ReactionEntity reaction) {
        return repository.save(reaction);
    }

    // CREATE a reaction for a specific user + post or comment
    public ReactionEntity createReactionForTarget(int userID, Integer postID, Integer commentID, String reactionType) {
        UserEntity user = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userID));

        PostEntity post = null;
        CommentEntity comment = null;

        if (postID != null) {
            post = postRepository.findById(postID.intValue())
                    .orElseThrow(() -> new RuntimeException("Post not found with ID: " + postID));
        }

        if (commentID != null) {
            comment = commentRepository.findById(commentID.intValue())
                    .orElseThrow(() -> new RuntimeException("Comment not found with ID: " + commentID));
        }

        ReactionEntity reaction = new ReactionEntity();
        reaction.setUser(user);
        reaction.setPost(post);
        reaction.setComment(comment);
        reaction.setReactionType(reactionType);

        return repository.save(reaction);
    }

    // GET reaction by ID
    public ReactionEntity findReactionById(int id) {
        return repository.findById(id).orElseThrow();
    }

    // GET all reactions
    public List<ReactionEntity> findAllReactions() {
        return repository.findAll();
    }

    // UPDATE reaction
    @Transactional
    public ReactionEntity updateReaction(int id, ReactionEntity updatedReaction) {
        ReactionEntity existingReaction = repository.findById(id).orElseThrow();

        existingReaction.setReactionType(updatedReaction.getReactionType());

        if (updatedReaction.getUser() != null) {
            existingReaction.setUser(updatedReaction.getUser());
        }

        if (updatedReaction.getPost() != null) {
            existingReaction.setPost(updatedReaction.getPost());
        }

        if (updatedReaction.getComment() != null) {
            existingReaction.setComment(updatedReaction.getComment());
        }

        return repository.save(existingReaction);
    }

    // DELETE reaction
    public void deleteReaction(int id) {
        repository.deleteById(id);
    }
}
