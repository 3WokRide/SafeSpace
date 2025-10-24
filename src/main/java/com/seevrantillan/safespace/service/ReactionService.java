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

    public ReactionEntity createReaction(ReactionEntity reaction) {
        return repo.save(reaction);
    }

    public List<ReactionEntity> getAllReactions() {
        return repo.findAll();
    }

    public ReactionEntity getReactionById(long reactionId) {
        return repo.findById(reactionId)
                .orElseThrow(() -> new NoSuchElementException("Reaction not found with ID: " + reactionId));
    }

    public ReactionEntity updateReactionType(long reactionId, String newReactionType) {
        ReactionEntity existingEntity = repo.findById(reactionId)
                .orElseThrow(() -> new NoSuchElementException("Reaction not found with ID: " + reactionId));

        existingEntity.setReactionType(newReactionType);
        return repo.save(existingEntity);
    }
}
