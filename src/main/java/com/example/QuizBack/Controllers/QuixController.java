package com.example.QuizBack.Controllers;

import com.example.QuizBack.Models.Answer;
import com.example.QuizBack.Models.Question;
import com.example.QuizBack.Services.Operations;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuixController<addquiz> {

    @Autowired
    private Operations op;

    @GetMapping("/get/{code}")
    public ResponseEntity<?> getquizbyid(@PathVariable("code") String code){
        Question q = this.op.getquizbycode(code);

        if(q == null){
            return ResponseEntity.status(404).body("notfound");
        }
        else{
            return  ResponseEntity.status(200).body(q);
        }
    }

    @PostMapping("/saveanswer")
    public ResponseEntity<?> saveAnswer(@RequestBody Answer ans){
        Answer a = this.op.saveanswers(ans);
        return ResponseEntity.status(200).body(a);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addquiz(@RequestBody Question q){
        return ResponseEntity.status(200).body(this.op.savequestion(q));
    }


}
