package com.example.QuizApp.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.example.QuizApp.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends EntityGraphJpaRepository<User, Long> {
}
