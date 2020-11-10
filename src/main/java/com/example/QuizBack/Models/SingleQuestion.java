package com.example.QuizBack.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SingleQuestion {

    @NotBlank
    private String question;

    @NotBlank
    private String[] options;

    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String correctoption;

}
