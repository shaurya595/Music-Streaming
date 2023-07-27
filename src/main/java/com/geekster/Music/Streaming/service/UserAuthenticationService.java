package com.geekster.Music.Streaming.service;

import com.geekster.Music.Streaming.model.User;
import com.geekster.Music.Streaming.model.UserAuthentication;
import com.geekster.Music.Streaming.repositeries.IUserAuthenticationRepository;
import com.geekster.Music.Streaming.repositeries.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    IUserAuthenticationRepository authenticationRepository;

    public boolean authenticate(String userEmail, String token) {
        User user = userRepository.findByUserEmail(userEmail);
        UserAuthentication authToken = authenticationRepository.findByUser(user);
        return token.equals(authToken.getToken());
    }
}
