package com.example.QuizBack.Models;

import com.example.QuizBack.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@Document
public class Register {

    @Getter
    @JsonIgnore
    private String userid;


    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @NotBlank
    private String email;

    @NotBlank
    private String password;


    @NotBlank
    private UserType usertype;

    public Register(){
        this.userid = UUID.randomUUID().toString();
    }

}
