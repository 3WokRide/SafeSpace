package com.seevrantillan.safespace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/reactions")
public class ReactionController {

    private final ReactionService service;

    public ReactionController(ReactionService service) {
        this.service = service;
    }

    @PostMapping("/createReaction")
    public ReactionEntity createReaction(@RequestBody ReactionEntity reactionEntity) {
        return service.saveReaction(reactionEntity);
    }

    @GetMapping("/getAllReactions")
    public List<ReactionEntity> getAllReactions() {
        return service.getAllReactions();
    }

    @GetMapping("/getReaction/{reactionId}")
    public ReactionEntity getReactionById(@PathVariable int reactionId) {
        return service.getReactionById(reactionId);
    }

    @PutMapping("/updateReactionType/{reactionId}")
    public ReactionEntity updateReactionType(@PathVariable int reactionId, @RequestBody String newReactionType) {
        return service.updateReactionType(reactionId, newReactionType);
    }

    @DeleteMapping("/deleteReaction/{reactionId}")
    public String deleteReaction(@PathVariable int reactionId) {
        service.deleteReaction(reactionId);
        return "Reaction with ID " + reactionId + " has been deleted successfully.";
    }
}
