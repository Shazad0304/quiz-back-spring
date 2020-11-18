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

@Document
public class Answer {
    @Getter
    @Setter
    @NotBlank
    private String code;
    @Getter
    @Setter
    @NotBlank
    private List<SIngleAnswer> answers;

    @Getter
    @Setter
    @NotBlank
    private String attemptedBy;

    @Getter @Setter
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String createdAt;

    @Getter @Setter
    private String[] images;

    public Answer(){
        this.createdAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
    }


}
