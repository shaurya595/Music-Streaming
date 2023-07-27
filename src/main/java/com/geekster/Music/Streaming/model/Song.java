package com.geekster.Music.Streaming.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;
    @NotNull
    private String songName;
    @NotNull
    private String singer;
    @NotNull
    private String band;
    @NotNull
    private LocalDate releaseDate;

    @ManyToOne
    private Playlist playlist;
}
