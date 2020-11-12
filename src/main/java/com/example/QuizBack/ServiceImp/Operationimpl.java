package com.example.QuizBack.ServiceImp;

import com.example.QuizBack.Models.Answer;
import com.example.QuizBack.Models.Question;
import com.example.QuizBack.Mongoconfig.connect;
import com.example.QuizBack.Services.Operations;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;


@Component
public class Operationimpl implements Operations {

    private MongoOperations mo = connect.get();

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
            return this.mo.save(ans);
        }
        else{
            return a;
        }

    }
}
