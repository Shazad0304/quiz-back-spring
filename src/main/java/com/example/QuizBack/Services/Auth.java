package com.example.QuizBack.Services;

import com.example.QuizBack.Models.Answer;
import com.example.QuizBack.Models.Login;
import com.example.QuizBack.Models.Question;
import com.example.QuizBack.Models.Register;

import java.util.Map;

public interface Auth {
    Register register(Register reg);

    Map<String,Object> loginuser(Login log);


}
