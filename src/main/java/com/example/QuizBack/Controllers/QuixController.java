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
public class QuixController {

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

    @GetMapping("/getall/{id}")
    public ResponseEntity<?> getallbyuserid(@PathVariable("id") String id){

            return  ResponseEntity.status(200).body(this.op.getallbyuser(id));
    }

    @GetMapping("/getallanswers/{code}")
    public ResponseEntity<?> getanswersbycode(@PathVariable("code") String code){

        return  ResponseEntity.status(200).body(this.op.getallscoresbycode(code));
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

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<?> deletequiz(@PathVariable("code") String code){
        return ResponseEntity.status(200).body(this.op.deletequiz(code));
    }

}
