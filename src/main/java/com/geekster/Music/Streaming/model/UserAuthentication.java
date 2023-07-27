package com.geekster.Music.Streaming.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserAuthentication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authenticationId;
    private String token;
    private LocalDateTime tokenCreationDate;

    @OneToOne
    private User user;

    public UserAuthentication(User user) {
        this.token = UUID.randomUUID().toString();
        this.tokenCreationDate = LocalDateTime.now();
        this.user = user;
    }
}
