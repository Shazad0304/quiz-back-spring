package com.example.QuizBack.Models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SIngleAnswer {

    @NotBlank
    private String ques;

    @NotBlank
    private String ans;
}
