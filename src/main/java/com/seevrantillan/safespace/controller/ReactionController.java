package com.seevrantillan.safespace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seevrantillan.safespace.entity.ReactionEntity;
import com.seevrantillan.safespace.service.ReactionService;

@RestController
@RequestMapping("/api/reactions")
public class ReactionController {

    private final ReactionService service;

    public ReactionController(ReactionService service) {
        this.service = service;
    }

    @PostMapping
    public ReactionEntity createReaction(@RequestBody ReactionEntity reactionEntity) {
        return service.createReaction(reactionEntity);
    }

    @GetMapping
    public List<ReactionEntity> getAllReactions() {
        return service.getAllReactions();
    }

    @GetMapping("/{reactionId}")
    public ReactionEntity getReactionById(@PathVariable int reactionId) {
        return service.getReactionById(reactionId);
    }

    @PutMapping("/{reactionId}")
    public ReactionEntity updateReactionType(@PathVariable int reactionId, @RequestBody String newReactionType) {
        return service.updateReactionType(reactionId, newReactionType);
    }
}
