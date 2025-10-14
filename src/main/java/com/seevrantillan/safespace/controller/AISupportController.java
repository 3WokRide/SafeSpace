package com.seevrantillan.safespace.controller;

import com.seevrantillan.safespace.entity.AISupportEntity;
import com.seevrantillan.safespace.service.AISupportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aisupports")
public class AISupportController {
    private final AISupportService service;

    public AISupportController(AISupportService service) {
        this.service = service;
    }

    @PostMapping("/createAISupport")
    public AISupportEntity createAISupport(@RequestBody AISupportEntity AISupportEntity) {
        return service.saveAISupport(AISupportEntity);
    }

    @GetMapping("/getAllAISupports")
    public List<AISupportEntity> getAllAISupports() {
        return service.getAllAISupports();
    }

    @PutMapping("/updateAISupportQuestion/{aiID}")
    public AISupportEntity updateAISupportQuestion(@PathVariable int aiID, @RequestBody String newQuestion) {
        return service.updateAISupportQuestion(aiID, newQuestion);
    }
}

