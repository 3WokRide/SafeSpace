package com.seevrantillan.safespace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seevrantillan.safespace.entity.ProgressEntity;
import com.seevrantillan.safespace.repository.ProgressRepository;

import jakarta.transaction.Transactional;

@Service
public class ProgressService {

    private final ProgressRepository repository;

    public ProgressService(ProgressRepository repository) {
        this.repository = repository;
    }

    public ProgressEntity createProgress(Integer score, Integer badgesEarned, Integer progressLevel) {
        ProgressEntity entity = new ProgressEntity(score, badgesEarned, progressLevel);
        return repository.save(entity);
    }

    public ProgressEntity createProgress(ProgressEntity entity) {
        return repository.save(entity);
    }

    public ProgressEntity getProgressById(long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<ProgressEntity> getAllProgress() {
        return repository.findAll();
    }
    
    @Transactional
    public ProgressEntity updateProgress(long id, ProgressEntity updatedProgress) {
        ProgressEntity existingProgress = repository.findById(id).orElseThrow();
        existingProgress.setScore(updatedProgress.getScore());
        existingProgress.setProgressLevel(updatedProgress.getProgressLevel());
        existingProgress.setBadgesEarned(updatedProgress.getBadgesEarned());
        return repository.save(existingProgress);
    }
}
