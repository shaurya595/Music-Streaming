package com.geekster.Music.Streaming.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    @NotNull
    private String adminFirstName;

    @NotNull
    private String adminLastName;

    @Email(regexp = "[A-Za-z0-9]+@admin\\.com")
    private String adminEmail;

    @NotNull
    private String adminPassword;

    public Admin(String adminFirstName, String adminLastName, String adminEmail, String adminPassword) {
        this.adminFirstName = adminFirstName;
        this.adminLastName = adminLastName;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }
}
