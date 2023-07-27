package com.geekster.Music.Streaming.service;

import com.geekster.Music.Streaming.dto.SignInInput;
import com.geekster.Music.Streaming.dto.SignInOutput;
import com.geekster.Music.Streaming.dto.SignUpUser;
import com.geekster.Music.Streaming.model.Playlist;
import com.geekster.Music.Streaming.model.User;
import com.geekster.Music.Streaming.model.UserAuthentication;
import com.geekster.Music.Streaming.repositeries.IUserAuthenticationRepository;
import com.geekster.Music.Streaming.repositeries.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    IUserAuthenticationRepository authenticationRepository;

    @Autowired
    PlaylistService playlistService;

    public void signup(SignUpUser signUpUser) {
        //check if user already present or not
        boolean checkIfPresent = userRepository.existsByUserEmail(signUpUser.getUserEmail());

        if (checkIfPresent) {
            throw new IllegalStateException("User is already present....please sign in");
        }

        //Encrypt password
        String encryptedPassword = null;

        try {
            encryptedPassword = encypt(signUpUser.getUserPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //save user
        User user = new User(signUpUser.getUserFirstName(), signUpUser.getUserLastName(), signUpUser.getUserEmail(), encryptedPassword);

        userRepository.save(user);
    }

    private String encypt(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digest = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digest);
        return hash;
    }

    public SignInOutput signIn(SignInInput signIn) {
        //check if user already present or not
        User user = userRepository.findByUserEmail(signIn.getUserEmail());

        if (user == null) {
            throw new IllegalStateException("User is not present");
        }

        //Encrypt password
        String encryptedPassword = null;

        try {
            encryptedPassword = encypt(signIn.getUserPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean checkPassword = encryptedPassword.equals(user.getUserPassword());
        if (!checkPassword) {
            throw new IllegalStateException("User is not present");
        }

        UserAuthentication token = new UserAuthentication(user);
        authenticationRepository.save(token);
        return new SignInOutput("signin Successful", token.getToken());
    }

    public Playlist getPlaylists(String userEmail) {
        User user = userRepository.findByUserEmail(userEmail);
        return user.getPlaylist();
    }

    public String deletePlaylist(String userEmail, Long playlistId) {
        User user = userRepository.findByUserEmail(userEmail);
        playlistService.deleteById(user.getPlaylist().getPlaylistId());
        return "Playlist deleted";
    }
}
