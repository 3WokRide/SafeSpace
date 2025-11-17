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

import com.seevrantillan.safespace.entity.AISupportEntity;
import com.seevrantillan.safespace.service.AISupportService;

@RestController
@RequestMapping("/aisupports")
public class AISupportController {
    private final AISupportService service;

    public AISupportController(AISupportService service) {
        this.service = service;
    }

    @PostMapping(value = "/createAISupport", consumes = MediaType.APPLICATION_JSON_VALUE)
    public AISupportEntity createAISupport(@RequestBody AISupportEntity AISupportEntity) {
        return service.saveAISupport(AISupportEntity);
    }

    @GetMapping("/getAllAISupports")
    public List<AISupportEntity> getAllAISupports() {
        return service.getAllAISupports();
    }

    @PutMapping(value = "/updateAISupportQuestion/{aiID}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public AISupportEntity updateAISupportQuestion(@PathVariable int aiID, @RequestBody String newQuestion) {
        return service.updateAISupportQuestion(aiID, newQuestion);
    }
}

