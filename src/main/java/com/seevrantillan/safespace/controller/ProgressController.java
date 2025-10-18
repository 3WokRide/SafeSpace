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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/progresses")
public class ProgressController {
    private final ProgressService service;

    public ProgressController(ProgressService service) {
        this.service = service;
    }

    @PostMapping("/createProgress")
    public ProgressEntity createProgress(@RequestBody ProgressEntity progress) {
        return service.createProgress(progress);
    }

    @GetMapping("/getAllProgresses")
    public List<ProgressEntity> getAllProgresses() {
        return service.findAllProgress();
    }

    @GetMapping("/getProgress/{id}")
    public ProgressEntity getProgressById(@PathVariable Long id) {
        return service.findProgressById(id);
    }

    @PutMapping("/updateProgress/{id}")
    public ProgressEntity updateProgress(@PathVariable Long id, @RequestBody ProgressEntity entity) {
        return service.updateProgress(id, entity);
    }

}
