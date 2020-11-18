package com.example.QuizBack.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
    private List<SingleQuestion> questions;
    @Getter @Setter
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String code;

    @Getter @Setter
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String createdAt;

    public Question(){
        this.code  = UUID.randomUUID().toString();
        this.createdAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
    }


}
