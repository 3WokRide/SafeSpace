package com.seevrantillan.safespace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seevrantillan.safespace.entity.TopicEntity;

@Repository
public interface TopicRepository extends JpaRepository<TopicEntity, Long>{

}
