package com.example.QuizApp.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.example.QuizApp.model.entity.Quiz;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends EntityGraphJpaRepository<Quiz, Long> {
}
