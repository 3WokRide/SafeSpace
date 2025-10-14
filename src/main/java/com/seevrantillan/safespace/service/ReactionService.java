package com.seevrantillan.safespace.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seevrantillan.safespace.entity.ReactionEntity;
import com.seevrantillan.safespace.repository.ReactionRepository;

@Service
public class ReactionService {

    @Autowired
    private final ReactionRepository repo;

    public ReactionService(ReactionRepository repo) {
        this.repo = repo;
    }

    public ReactionEntity saveReaction(ReactionEntity reaction) {
        return repo.save(reaction);
    }

    public ReactionEntity updateReactionType(int reactionId, String newReactionType) {
        ReactionEntity existingEntity = repo.findById(reactionId)
                .orElseThrow(() -> new NoSuchElementException("Reaction not found with ID: " + reactionId));

        existingEntity.setReactionType(newReactionType);
        return repo.save(existingEntity);
    }

    public List<ReactionEntity> getAllReactions() {
        return repo.findAll();
    }

    public ReactionEntity getReactionById(int reactionId) {
        return repo.findById(reactionId)
                .orElseThrow(() -> new NoSuchElementException("Reaction not found with ID: " + reactionId));
    }

    public void deleteReaction(int reactionId) {
        if (!repo.existsById(reactionId)) {
            throw new NoSuchElementException("Reaction not found with ID: " + reactionId);
        }
        repo.deleteById(reactionId);
    }
}
