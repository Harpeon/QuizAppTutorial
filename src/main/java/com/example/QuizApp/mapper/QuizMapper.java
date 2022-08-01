package com.example.QuizApp.mapper;


import com.example.QuizApp.model.entity.Quiz;
import com.example.QuizApp.model.request.update.QuizUpdateDTO;
import com.example.QuizApp.model.response.QuizDetailResponseDTO;
import com.example.QuizApp.model.response.QuizResponseDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper(config = SharedConfig.class)
public interface QuizMapper {
    @Named(value = "quizResponseDTO")
    QuizResponseDTO map(Quiz quiz);

    QuizDetailResponseDTO mapDetail(Quiz user);

    @IterableMapping(qualifiedByName = "quizResponseDTO")
    List<QuizResponseDTO> mapList(List<Quiz> user);

    void merge(@MappingTarget Quiz quiz, QuizUpdateDTO quizUpdateDTO);

}