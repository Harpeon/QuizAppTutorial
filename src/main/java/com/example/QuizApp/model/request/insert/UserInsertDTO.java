package com.example.QuizApp.model.request.insert;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class UserInsertDTO {
    private String name;
    private String surname;
    @Size(min = 3, max = 20)
    private String identifier;
    @Size(min = 5, max = 20)
    private String password;
    @NotNull
    private LocalDate dob;
}
