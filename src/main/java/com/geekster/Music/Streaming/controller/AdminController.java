package com.geekster.Music.Streaming.controller;

import com.geekster.Music.Streaming.dto.SignInInput;
import com.geekster.Music.Streaming.dto.SignInOutput;
import com.geekster.Music.Streaming.dto.SignUpAdmin;
import com.geekster.Music.Streaming.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody SignUpAdmin signUpAdmin){
        String response;
        HttpStatus status;

        try {
            adminService.signup(signUpAdmin);
            response = "admin created successfully";
            status = HttpStatus.CREATED;
        }catch (Exception e){
            response = "Enter Valid Data";
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<String>(response, status);
    }

    @PostMapping("signin")
    public SignInOutput signin(@RequestBody SignInInput signIn){
        return adminService.signIn(signIn);
    }
}
