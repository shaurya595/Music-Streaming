package com.geekster.Music.Streaming.service;

import com.geekster.Music.Streaming.model.Admin;
import com.geekster.Music.Streaming.model.AdminAuthentication;
import com.geekster.Music.Streaming.repositeries.IAdminAuthenticationRepository;
import com.geekster.Music.Streaming.repositeries.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthenticationService  {
    @Autowired
    IAdminRepository adminRepository;

    @Autowired
    IAdminAuthenticationRepository authenticationRepository;

    public boolean authenticate(String adminEmail, String token) {
        Admin admin = adminRepository.findAdminByAdminEmail(adminEmail);
        AdminAuthentication authToken = authenticationRepository.findByToken(token);
        boolean authenticate = authToken.getToken().equals(token);
        return authenticate;
    }
}
