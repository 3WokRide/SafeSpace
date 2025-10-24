package com.seevrantillan.safespace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seevrantillan.safespace.entity.CommentEntity;
import com.seevrantillan.safespace.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @PostMapping
    public CommentEntity createComment(@RequestBody CommentEntity commentEntity) {
        return service.createComment(commentEntity);
    }

    @GetMapping
    public List<CommentEntity> getAllComments() {
        return service.getAllComments();
    }

    @GetMapping("/{commentId}")
    public CommentEntity getCommentById(@PathVariable int commentId) {
        return service.getCommentById(commentId);
    }

    @PutMapping("/content/{commentId}")
    public CommentEntity updateCommentContent(@PathVariable int commentId, @RequestBody String newContent) {
        return service.updateCommentContent(commentId, newContent);
    }

    @PutMapping("/votes/{commentId}")
    public CommentEntity updateVotes(@PathVariable int commentId, 
                                     @RequestParam int upvotes, 
                                     @RequestParam int downvotes) {
        return service.updateVotes(commentId, upvotes, downvotes);
    }
}
