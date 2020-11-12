package com.example.QuizBack.ServiceImp;

import com.example.QuizBack.Models.Login;
import com.example.QuizBack.Models.Register;
import com.example.QuizBack.Mongoconfig.connect;
import com.example.QuizBack.Services.Auth;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class Authimpl implements Auth {

    private MongoOperations mo = connect.get();

    @Override
    public Register register(Register reg) {
        Query q = new Query();
        q.addCriteria(Criteria.where("email").is(reg.getEmail()));

        if(this.mo.findOne(q,Register.class) == null){
            return this.mo.save(reg);
        }
        else{
           return null;
        }

    }

    @Override
    public Map<String,Object> loginuser(Login log) {
        Query q = new Query();
        q.addCriteria(Criteria.where("email").is(log.getEmail()).and("password").is(log.getPassword()));
        Register reg = this.mo.findOne(q,Register.class);
        Map<String,Object> map = new HashMap<>();
        if(reg == null){
            return null;
        }
        else{
            map.put("id",reg.getUserid());
            map.put("type",reg.getUsertype());
            return map;
        }
    }
}
