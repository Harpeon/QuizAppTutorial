package com.example.QuizApp.model.request.update;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserUpdateDTO {
    private String name;
    private String surname;
    private LocalDate dob;
}
