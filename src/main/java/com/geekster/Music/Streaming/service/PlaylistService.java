package com.geekster.Music.Streaming.service;

import com.geekster.Music.Streaming.model.Playlist;
import com.geekster.Music.Streaming.model.User;
import com.geekster.Music.Streaming.repositeries.PlaylistRepository;
import com.geekster.Music.Streaming.repositeries.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {
    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SongService songService;

    public String addPlayList(String userEmail, Playlist playlist) {
        User user = userRepository.findByUserEmail(userEmail);

        user.setPlaylist(playlist);
        playlistRepository.save(playlist);
        return "Playlist added successfully";
    }

    public void deleteById(Long playlistId) {
        playlistRepository.deleteById(playlistId);
    }
}
