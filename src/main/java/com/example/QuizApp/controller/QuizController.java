package com.example.QuizApp.controller;


import com.example.QuizApp.model.request.insert.QuizInsertDTO;
import com.example.QuizApp.model.request.update.AnswerUpdateDTO;
import com.example.QuizApp.model.request.update.QuizUpdateDTO;
import com.example.QuizApp.model.response.QuizDetailResponseDTO;
import com.example.QuizApp.model.response.QuizResponseDTO;
import com.example.QuizApp.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;


    @GetMapping("")
    public List<QuizResponseDTO> getQuizzes() {
        return quizService.findAll();
    }

    @GetMapping(path = "/{quizId}")
    public QuizDetailResponseDTO getDetail(@PathVariable("quizId") Long quizId) {
        return quizService.getDetail(quizId);
    }

    @PostMapping(path = "")
    public QuizResponseDTO createQuiz(@Valid @RequestBody QuizInsertDTO quizCreateDTO) {
        return quizService.createQuiz(quizCreateDTO);
    }

    @PutMapping(path = "/{quizId}")
    public void updateQuiz(@PathVariable("quizId") Long quizId, @RequestBody QuizUpdateDTO quizUpdateDTO) {
        quizService.updateQuiz(quizId, quizUpdateDTO);
    }

    @PutMapping(path = "/{quizId}/answer/{answerId}")
    public void updateAnswer(@PathVariable("quizId") Long quizId, @PathVariable("answerId") Long answerId, @RequestBody AnswerUpdateDTO answerUpdateDTO) {
        quizService.updateAnswer(quizId, answerId, answerUpdateDTO);
    }

    @DeleteMapping(path = "/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long quizId) {
        quizService.deleteQuiz(quizId);
    }


}
