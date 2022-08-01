package com.example.QuizApp.service;


import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.example.QuizApp.mapper.QuizMapper;
import com.example.QuizApp.model.entity.Answer;
import com.example.QuizApp.model.entity.Quiz;
import com.example.QuizApp.model.request.insert.AnswerInsertDTO;
import com.example.QuizApp.model.request.insert.QuizInsertDTO;
import com.example.QuizApp.model.request.update.AnswerUpdateDTO;
import com.example.QuizApp.model.request.update.QuizUpdateDTO;
import com.example.QuizApp.model.response.QuizDetailResponseDTO;
import com.example.QuizApp.model.response.QuizResponseDTO;
import com.example.QuizApp.repository.AnswerRepository;
import com.example.QuizApp.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;
    private final AnswerRepository answerRepository;
    private final QuizMapper quizMapper;


    public List<QuizResponseDTO> findAll() {
        return quizMapper.mapList(quizRepository.findAll());
    }


    public QuizDetailResponseDTO getDetail(Long id) {
        return quizMapper.mapDetail(quizRepository.findById(id, getQuizEntityGraph()).orElseThrow(() -> new IllegalStateException("Quiz with ID " + id + "does not exist")));
    }

    EntityGraph getQuizEntityGraph() {
        return EntityGraphUtils.fromAttributePaths(
                Quiz.Fields.answers
        );
    }

    @Transactional
    public QuizResponseDTO createQuiz(QuizInsertDTO quizInsertDTO) {
        Quiz quiz = Quiz.builder()
                .name(quizInsertDTO.getName())
                .question(quizInsertDTO.getQuestion())
                .build();
        quiz = quizRepository.save(quiz);
        for (AnswerInsertDTO answerInsertDTO : quizInsertDTO.getAnswers()) {
            Answer answer = Answer.builder()
                    .answer(answerInsertDTO.getAnswer())
                    .quiz(quiz)
                    .build();
            answerRepository.save(answer);
        }
        return quizMapper.map(quiz);
    }

    @Transactional
    public void updateQuiz(Long id, QuizUpdateDTO quizUpdateDTO) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new IllegalStateException("Quiz with id " + id + " does not exist"));
        quizMapper.merge(quiz, quizUpdateDTO);
        quizRepository.save(quiz);
    }

    @Transactional
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    @Transactional
    public void updateAnswer(Long quizId, Long answerId, AnswerUpdateDTO answerUpdateDTO) {
        Answer answer = answerRepository.findByQuizIdAndId(quizId, answerId).orElseThrow(() -> new IllegalStateException("Answer with quizId " + quizId + " and id " + answerId + " does not exist"));
        answer.setAnswer(answerUpdateDTO.getAnswer());
        answerRepository.save(answer);
    }
}
