package com.example.QuizApp.config;


import com.example.QuizApp.model.entity.User;
import com.example.QuizApp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;

import static java.time.Month.AUGUST;
import static java.time.Month.JUNE;

@Configuration
public class UserConfig {
    @Bean
    @Transactional
    CommandLineRunner commandLineRunner2(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                User first = User.builder()
                        .identifier("user1")
                        .password("password1")
                        .name("name1")
                        .surname("surname1")
                        .dob(LocalDate.of(2000, AUGUST, 5))
                        .build();

                User second = User.builder()
                        .identifier("user2")
                        .password("password2")
                        .name("name2")
                        .surname("surname2")
                        .dob(LocalDate.of(1995, JUNE, 13))
                        .build();

                userRepository.saveAll(Arrays.asList(first, second));
            }
        };
    }
}
