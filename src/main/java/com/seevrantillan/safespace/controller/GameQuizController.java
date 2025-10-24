package com.seevrantillan.safespace.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seevrantillan.safespace.entity.GameQuizEntity;
import com.seevrantillan.safespace.service.GameQuizService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/game-quizzes")
public class GameQuizController {
    private final GameQuizService service;

    public GameQuizController(GameQuizService service) {
        this.service = service;
    }

    @PostMapping
    public GameQuizEntity createGameQuiz(@RequestBody GameQuizEntity gameQuiz) {
        return service.createGameQuiz(gameQuiz);
    }

    @GetMapping
    public List<GameQuizEntity> getAllGameQuizzes() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GameQuizEntity getGameQuizById(@PathVariable Long id) {
        return service.getGameQuizById(id);
    }

    @PutMapping("/{id}")
    public GameQuizEntity updateGameQuiz(@PathVariable Long id, @RequestBody GameQuizEntity entity) {
        return service.updateGameQuiz(id, entity);
    }
}
