package com.seevrantillan.safespace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seevrantillan.safespace.entity.ProgressEntity;

@Repository
public interface ProgressRepository extends JpaRepository<ProgressEntity, Long> {

}
