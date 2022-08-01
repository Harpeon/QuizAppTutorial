package com.example.QuizApp.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.example.QuizApp.model.entity.Answer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerRepository extends EntityGraphJpaRepository<Answer, Long> {
    Optional<Answer> findByQuizIdAndId(Long quizId, Long id);
}
