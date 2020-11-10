package com.example.QuizBack.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Document
public class Question {
    @Getter
    @Setter
    @NotBlank
    private String title;
    @Getter @Setter
    @NotBlank
    private String createdBy;
    @Getter @Setter
    @NotBlank
    private SingleQuestion[] questions;
    @Getter @Setter
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String code;

    public Question(){
        this.code  = UUID.randomUUID().toString();
    }


}
