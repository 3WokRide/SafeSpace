package com.seevrantillan.safespace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seevrantillan.safespace.entity.GameQuizEntity;
import com.seevrantillan.safespace.repository.GameQuizRepository;

import jakarta.transaction.Transactional;

@Service
public class GameQuizService {
    private final GameQuizRepository repository;

    public GameQuizService(GameQuizRepository repository) {
        this.repository = repository;
    }

    public GameQuizEntity createGameQuiz(String title, Integer score, String type) {
        GameQuizEntity entity = new GameQuizEntity(title, score, type);
        return repository.save(entity);
    }

    public GameQuizEntity createGameQuiz(GameQuizEntity entity) {
        return repository.save(entity);
    }

    public GameQuizEntity getGameQuizById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<GameQuizEntity> getAll() {
        return repository.findAll();
    }

    @Transactional
    public GameQuizEntity updateGameQuiz(Long id, GameQuizEntity updated) {
        GameQuizEntity existing = repository.findById(id).orElseThrow();
        existing.setScore(updated.getScore());
        existing.setTitle(updated.getTitle());
        existing.setType(updated.getType());
        return repository.save(existing);
    }
}
