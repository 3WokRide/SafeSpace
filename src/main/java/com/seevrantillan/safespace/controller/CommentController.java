package com.seevrantillan.safespace.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seevrantillan.safespace.DTO.CommentDTO;
import com.seevrantillan.safespace.entity.CommentEntity;
import com.seevrantillan.safespace.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
public CommentEntity createComment(@RequestBody CommentDTO dto) {
    return service.createCommentForUserPost(dto.getUserID(), dto.getPostID(), dto.getContent());
}

    @GetMapping()
    public List<CommentEntity> findAllComments() {
        return service.findAllComments();
    }

    @GetMapping("/{id}")
    public CommentEntity findCommentById(@PathVariable int id) {
        return service.findCommentById(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommentEntity updateComment(@PathVariable int id, @RequestBody CommentEntity updatedComment) {
        return service.updateComment(id, updatedComment);
    }

    @PutMapping("/{id}/votes")
    public CommentEntity updateVotes(
            @PathVariable int id,
            @RequestParam int upvotes,
            @RequestParam int downvotes) {
        return service.updateVotes(id, upvotes, downvotes);
    }

    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable int id) {
        service.deleteComment(id);
        return "Comment with ID " + id + " has been deleted successfully.";
    }
}
