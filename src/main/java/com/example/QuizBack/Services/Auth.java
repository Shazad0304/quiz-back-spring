package com.example.QuizBack.Services;

import com.example.QuizBack.Models.Answer;
import com.example.QuizBack.Models.Login;
import com.example.QuizBack.Models.Question;
import com.example.QuizBack.Models.Register;

public interface Auth {
    Register register(Register reg);

    String loginuser(Login log);


}
