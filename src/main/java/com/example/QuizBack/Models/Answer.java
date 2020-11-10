package com.example.QuizBack.Models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
public class Answer {
    @Getter
    @Setter
    @NotBlank
    private String code;
    @Getter
    @Setter
    @NotBlank
    private SIngleAnswer[] Answers;

    @Getter
    @Setter
    @NotBlank
    private String attemptedBy;



}
