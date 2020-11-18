package com.example.QuizBack.ServiceImp;

import com.example.QuizBack.Models.*;
import com.example.QuizBack.Mongoconfig.connect;
import com.example.QuizBack.Services.Auth;
import com.example.QuizBack.Services.Operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Component
public class Operationimpl implements Operations {

    private MongoOperations mo = connect.get();

    @Autowired
    private Auth authservice;

    @Override
    public Question savequestion(Question q) {
        return this.mo.save(q);
    }

    @Override
    public Question getquizbycode(String code) {
        Query q = new Query();
        q.addCriteria(Criteria.where("code").is(code));
        return this.mo.findOne(q,Question.class);
    }

    @Override
    public Answer saveanswers(Answer ans) {
        Query q = new Query();
        q.addCriteria(Criteria.where("code").is(ans.getCode()).and("attemptedBy").is(ans.getAttemptedBy()));
        Answer a = this.mo.findOne(q,Answer.class);
        if(a == null){
            this.saveResults(ans);
            return this.mo.save(ans);
        }
        else{
            return a;
        }

    }

    @Override
    public List<Question> getallbyuser(String id) {
        Query q = new Query();
        q.addCriteria(Criteria.where("createdBy").is(id));
        return this.mo.find(q,Question.class);
    }

    @Override
    public Scores saveResults(Answer ans) {
        AtomicInteger score = new AtomicInteger();
        Question quiz = this.getquizbycode(ans.getCode());
        List<SIngleAnswer> answers = ans.getAnswers();
        answers.forEach(x -> {
            SingleQuestion ques = quiz.getQuestions().stream().filter(q -> q.getQuestion().equals(x.getQues())).findFirst().orElse(null);
            if(ques != null && ques.getCorrectoption().equals(x.getAns())){
                score.getAndIncrement();
            }
        });
        Register user = authservice.getuserbyid(ans.getAttemptedBy());
        Scores result = new Scores();
        result.setEmail(user.getEmail());
        result.setFirstName(user.getFirstname());
        result.setLastName(user.getLastname());
        result.setScore(score.get());
        result.setCode(ans.getCode());
        result.setCreatedAt(ans.getCreatedAt());
        result.setImages(ans.getImages());
        return this.mo.save(result);
    }

    @Override
    public List<Scores> getallscoresbycode(String code) {
        Query q = new Query();
        q.addCriteria(Criteria.where("code").is(code));
        return this.mo.find(q,Scores.class);
    }

    @Override
    public Question deletequiz(String code) {
        Query q = new Query();
        q.addCriteria(Criteria.where("code").is(code));
        return this.mo.findAndRemove(q,Question.class);
    }
}
