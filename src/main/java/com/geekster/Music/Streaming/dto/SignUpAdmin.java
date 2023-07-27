package com.geekster.Music.Streaming.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignUpAdmin {
    @NotNull
    private String adminFirstName;

    @NotNull
    private String adminLastName;

    @Email(regexp = "[A-Za-z0-9]+@admin\\.com")
    private String adminEmail;

    @NotNull
    private String adminPassword;
}
