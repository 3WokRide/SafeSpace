package com.seevrantillan.safespace.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seevrantillan.safespace.entity.ProgressEntity;
import com.seevrantillan.safespace.service.ProgressService;

@RestController
@RequestMapping("/progresses")
public class ProgressController {
    private final ProgressService service;

    public ProgressController(ProgressService service) {
        this.service = service;
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProgressEntity createProgress(@RequestBody ProgressEntity progress) {
        return service.createProgress(progress);
    }

    @GetMapping("/getAll")
    public List<ProgressEntity> getAllProgresses() {
        return service.findAllProgress();
    }

    @GetMapping("/get/{id}")
    public ProgressEntity getProgressById(@PathVariable Long id) {
        return service.findProgressById(id);
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProgressEntity updateProgress(@PathVariable Long id, @RequestBody ProgressEntity entity) {
        return service.updateProgress(id, entity);
    }

}
