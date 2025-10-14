package com.seevrantillan.safespace.service;

import com.seevrantillan.safespace.entity.AISupportEntity;
import com.seevrantillan.safespace.repository.AISupportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AISupportService {
    @Autowired
    private final AISupportRepository repo;

    public AISupportService(AISupportRepository repo) {
        this.repo = repo;
    }

    public AISupportEntity saveAISupport(AISupportEntity AISupport) {
        return repo.save(AISupport);
    }

    public AISupportEntity updateAISupportQuestion(int aiID, String newQuestion) {
        AISupportEntity existingEntity = repo.findById(aiID).orElseThrow(() -> new NoSuchElementException("AISupport not found with ID: " + aiID));

        existingEntity.setQuestion(newQuestion);
        existingEntity.setTimestamp(LocalDateTime.now());
        
        return repo.save(existingEntity);
    }

    public List<AISupportEntity> getAllAISupports() {
        return repo.findAll();
    }
}

