package com.example.QuizBack.Services;

import com.example.QuizBack.Models.Answer;
import com.example.QuizBack.Models.Question;
import com.example.QuizBack.Models.Scores;

import java.util.List;

public interface Operations {
    Question savequestion(Question q);

    Question getquizbycode(String code);

    Answer saveanswers(Answer ans);

    List<Question> getallbyuser(String id);

    Scores saveResults(Answer ans);

    List<Scores> getallscoresbycode(String code);

    Question deletequiz(String code);
}
