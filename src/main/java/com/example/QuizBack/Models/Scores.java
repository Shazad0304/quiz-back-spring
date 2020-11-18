package com.example.QuizBack.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Getter
@Setter
public class Scores {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String id;
    private String firstName;
    private String lastName;
    private String Email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String code;
    private int score;
    @Getter @Setter
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String createdAt;
    @Getter @Setter
    private String[] images;

    public Scores(){
        this.id = UUID.randomUUID().toString();
    }
}
