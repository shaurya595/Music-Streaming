package com.geekster.Music.Streaming.service;

import com.geekster.Music.Streaming.dto.SignInInput;
import com.geekster.Music.Streaming.dto.SignInOutput;
import com.geekster.Music.Streaming.dto.SignUpAdmin;
import com.geekster.Music.Streaming.model.Admin;
import com.geekster.Music.Streaming.model.AdminAuthentication;
import com.geekster.Music.Streaming.repositeries.IAdminAuthenticationRepository;
import com.geekster.Music.Streaming.repositeries.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AdminService {
    @Autowired
    IAdminRepository adminRepository;

    @Autowired
    IAdminAuthenticationRepository authenticationRepository;

    public void signup(SignUpAdmin signUpAdmin) {
        //check if Admin already present or not
        boolean checkIfPresent = adminRepository.existsByAdminEmail(signUpAdmin.getAdminEmail());

        if (checkIfPresent){
            throw new IllegalStateException("Admin is already present....please sign in");
        }

        //Encrypt password
        String encryptedPassword = null;

        try {
            encryptedPassword = encypt(signUpAdmin.getAdminPassword());
        }catch (Exception e){
            e.printStackTrace();
        }

        //save Admin
        Admin Admin = new Admin(signUpAdmin.getAdminFirstName(), signUpAdmin.getAdminLastName(), signUpAdmin.getAdminEmail(), encryptedPassword);

        adminRepository.save(Admin);
    }

    private String encypt(String adminPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(adminPassword.getBytes());
        byte[] digest = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digest);
        return hash;
    }

    public SignInOutput signIn(SignInInput signIn) {

        //check if user already present or not
        Admin admin = adminRepository.findAdminByAdminEmail(signIn.getUserEmail());

        if(admin == null){
            throw new IllegalStateException("User is not present");
        }

        //Encrypt password
        String encryptedPassword = null;

        try {
            encryptedPassword = encypt(signIn.getUserPassword());
        }catch (Exception e){
            e.printStackTrace();
        }

        boolean checkPassword = encryptedPassword.equals(admin.getAdminPassword());
        if (!checkPassword) {
            throw new IllegalStateException("User is not present");
        }

        AdminAuthentication token = new AdminAuthentication(admin);
        authenticationRepository.save(token);

        return new SignInOutput("signin Successful", token.getToken());
    }

    public boolean checkAdminPresentOrNot(String adminEmail){
        return adminRepository.existsByAdminEmail(adminEmail);
    }
}
