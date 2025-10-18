package com.seevrantillan.safespace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seevrantillan.safespace.entity.GameQuizEntity;

@Repository
public interface GameQuizRepository extends JpaRepository<GameQuizEntity, Long> {

}
