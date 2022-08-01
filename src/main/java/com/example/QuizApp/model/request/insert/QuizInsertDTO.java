package com.example.QuizApp.model.request.insert;

import lombok.Data;

import java.util.List;

@Data
public class QuizInsertDTO {
    private String name;
    private String question;
    private List<AnswerInsertDTO> answers;
}
