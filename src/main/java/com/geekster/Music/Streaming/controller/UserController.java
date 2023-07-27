package com.geekster.Music.Streaming.controller;

import com.geekster.Music.Streaming.dto.SignInInput;
import com.geekster.Music.Streaming.dto.SignInOutput;
import com.geekster.Music.Streaming.dto.SignUpUser;
import com.geekster.Music.Streaming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody SignUpUser signUpUser){
        String response;
        HttpStatus status;

        try {
            userService.signup(signUpUser);
            response = "User created successfully";
            status = HttpStatus.CREATED;
        }catch (Exception e){
            response = "Enter Valid Data";
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<String>(response, status);
    }

    @PostMapping("signin")
    public SignInOutput signin(@RequestBody SignInInput signIn){
        return userService.signIn(signIn);
    }

}
