package com.seevrantillan.safespace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/comments")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @PostMapping("/createComment")
    public CommentEntity createComment(@RequestBody CommentEntity commentEntity) {
        return service.saveComment(commentEntity);
    }

    @GetMapping("/getAllComments")
    public List<CommentEntity> getAllComments() {
        return service.getAllComments();
    }

    @GetMapping("/getComment/{commentId}")
    public CommentEntity getCommentById(@PathVariable int commentId) {
        return service.getCommentById(commentId);
    }

    @PutMapping("/updateCommentContent/{commentId}")
    public CommentEntity updateCommentContent(@PathVariable int commentId, @RequestBody String newContent) {
        return service.updateCommentContent(commentId, newContent);
    }

    @PutMapping("/updateVotes/{commentId}")
    public CommentEntity updateVotes(@PathVariable int commentId, 
                                     @RequestParam int upvotes, 
                                     @RequestParam int downvotes) {
        return service.updateVotes(commentId, upvotes, downvotes);
    }

    @DeleteMapping("/deleteComment/{commentId}")
    public String deleteComment(@PathVariable int commentId) {
        service.deleteComment(commentId);
        return "Comment with ID " + commentId + " has been deleted successfully.";
    }
}
