package com.example.QuizBack.Controllers;

import com.example.QuizBack.Models.Login;
import com.example.QuizBack.Models.Register;
import com.example.QuizBack.Services.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private Auth authservice;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody Register reg){
        Register resp =  this.authservice.register(reg);
        if(resp == null){
            Map<String,Object> map = new HashMap<>();
            map.put("error","Already existed");
           return ResponseEntity.status(409).body(map);
        }
        else{
            return ResponseEntity.status(200).body(resp);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody Login log){
        String id = this.authservice.loginuser(log);
        int resp = 200;

        Map<String,Object> map = new HashMap<>();
        if(id == null){
            map.put("error","user not found");
            resp = 401;
        }
        else{
            map.put("id",id);
            resp = 200;
        }

        return new ResponseEntity<Map<String,Object>>(map, HttpStatus.resolve(resp));
    }
}
