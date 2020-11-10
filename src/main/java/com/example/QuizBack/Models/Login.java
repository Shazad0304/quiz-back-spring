package com.example.QuizBack.Models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
public class Login {


    @NotBlank
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    @NotBlank
    private String password;
}
