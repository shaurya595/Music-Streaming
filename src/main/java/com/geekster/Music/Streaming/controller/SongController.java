package com.geekster.Music.Streaming.controller;

import com.geekster.Music.Streaming.model.Song;
import com.geekster.Music.Streaming.service.AdminAuthenticationService;
import com.geekster.Music.Streaming.service.AdminService;
import com.geekster.Music.Streaming.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("song")
public class SongController {
    @Autowired
    SongService songService;

    @Autowired
    AdminService adminService;

    @Autowired
    AdminAuthenticationService authenticationService;

    @PostMapping("/add/{adminEmail}/{token}")
    public String addSongs(@PathVariable String adminEmail, @PathVariable String token, @RequestBody List<Song> song){
        if (!authenticationService.authenticate(adminEmail, token)){
            return "You're not an Admin.. You cannot add songs";
        }
        return songService.addSongs(song);
    }

    @GetMapping
    public List<Song> getAllSongs(){
        return songService.getAllSongs();
    }

    @DeleteMapping("delete/{adminEmail}/{token}id/{songId}")
    public String deleteSong(@PathVariable String adminEmail, @PathVariable String token, @PathVariable Long songId){
        if (!authenticationService.authenticate(adminEmail, token)){
            return "You're not an Admin.. You cannot delete the song";
        }
        return songService.deleteSong(songId);
    }

    @PutMapping("/update/{adminEmail}/{token}")
    public String updateSong(@PathVariable String adminEmail, @PathVariable String token, @RequestBody Song song){
        if (!authenticationService.authenticate(adminEmail, token)){
            return "You're haven't signed in yet.. You cannot update songs";
        }
        return songService.updateSong(song);
    }
}
