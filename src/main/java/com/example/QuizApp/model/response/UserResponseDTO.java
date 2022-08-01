package com.example.QuizApp.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponseDTO extends BaseResponseDTO {
    private String name;
    private String surname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
}
