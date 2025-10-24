package com.seevrantillan.safespace.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seevrantillan.safespace.entity.ProgressEntity;
import com.seevrantillan.safespace.service.ProgressService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {
    private final ProgressService service;

    public ProgressController(ProgressService service) {
        this.service = service;
    }

    @PostMapping
    public ProgressEntity createProgress(@RequestBody ProgressEntity progress) {
        return service.createProgress(progress);
    }

    @GetMapping
    public List<ProgressEntity> getAllProgresses() {
        return service.getAllProgress();
    }

    @GetMapping("/{id}")
    public ProgressEntity getProgressById(@PathVariable Long id) {
        return service.getProgressById(id);
    }

    @PutMapping("/{id}")
    public ProgressEntity updateProgress(@PathVariable Long id, @RequestBody ProgressEntity entity) {
        return service.updateProgress(id, entity);
    }
}
