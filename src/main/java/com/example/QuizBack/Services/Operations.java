package com.example.QuizBack.Services;

import com.example.QuizBack.Models.Answer;
import com.example.QuizBack.Models.Question;

public interface Operations {
    Question savequestion(Question q);

    Question getquizbycode(String code);

    Answer saveanswers(Answer ans);
}
