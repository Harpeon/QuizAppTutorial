package com.example.QuizApp.model.response;

import lombok.Data;

import java.util.List;

@Data
public class QuizDetailResponseDTO extends QuizResponseDTO {
    private List<AnswerResponseDTO> answers;
}
