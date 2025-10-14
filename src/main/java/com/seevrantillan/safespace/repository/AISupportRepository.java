package com.seevrantillan.safespace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.seevrantillan.safespace.entity.AISupportEntity;

@Repository
public interface AISupportRepository extends JpaRepository<AISupportEntity, Integer> {
}
