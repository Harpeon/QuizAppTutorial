package com.example.QuizApp.model.response;

import lombok.Data;

@Data
public class QuizResponseDTO extends BaseResponseDTO {
    private String name;
    private String question;
}
