package com.example.QuizApp.model.response;

import lombok.Data;

@Data
public class UserDetailResponseDTO extends UserResponseDTO {
    private String identifier;
    private String password;
}
