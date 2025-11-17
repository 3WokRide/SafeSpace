package com.seevrantillan.safespace.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seevrantillan.safespace.DTO.ReactionDTO;
import com.seevrantillan.safespace.entity.ReactionEntity;
import com.seevrantillan.safespace.service.ReactionService;

@RestController
@RequestMapping("/reactions")
public class ReactionController {

    private final ReactionService service;

    public ReactionController(ReactionService service) {
        this.service = service;
    }

    // --- CREATE reaction (Simple JSON body mapping to entity) ---
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ReactionEntity createReaction(@RequestBody ReactionEntity reactionEntity) {
        return service.createReaction(reactionEntity);
    }

    // --- CREATE reaction for a specific target (User + Post or Comment) ---
    // Uses the ReactionDTO to read the JSON body for the target IDs.
    @PostMapping(value = "/createForTarget", consumes = MediaType.APPLICATION_JSON_VALUE) 
    public ReactionEntity createReactionForTarget(@RequestBody ReactionDTO targetDto) { 
        return service.createReactionForTarget(
            targetDto.getUserID(), 
            targetDto.getPostID(), 
            targetDto.getCommentID(), 
            targetDto.getReactionType()
        );
    }

    // --- GET all reactions ---
    @GetMapping
    public List<ReactionEntity> findAllReactions() {
        return service.findAllReactions();
    }

    // --- GET reaction by ID ---
    @GetMapping("/{id}")
    public ReactionEntity findReactionById(@PathVariable int id) {
        // NOTE: Recommend using ResponseEntity.ok() here and handling 404 in the service.
        return service.findReactionById(id); 
    }

    // --- UPDATE reaction ---
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ReactionEntity updateReaction(
            @PathVariable int id,
            @RequestBody ReactionEntity updatedReaction) {
        return service.updateReaction(id, updatedReaction);
    }

    // --- DELETE reaction (Returning 204 No Content is REST standard) ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReaction(@PathVariable int id) {
        service.deleteReaction(id);
        // Returns 204 NO_CONTENT status with an empty body.
        return ResponseEntity.noContent().build();
    }
}