package com.geekster.Music.Streaming.service;

import com.geekster.Music.Streaming.model.Song;
import com.geekster.Music.Streaming.repositeries.SongRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    SongRepository songRepository;

    public String addSongs(List<Song> song) {
        songRepository.saveAll(song);
        return "Songs added successfully...!!!";
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Transactional
    public String deleteSong(Long songId) {
        if (!songRepository.existsById(songId)){
            return "Song with id " + songId + " is not present.";
        }
        songRepository.deleteById(songId);
        return "Song with id " + songId + " gets deleted.";
    }

    @Transactional
    public String updateSong(Song song) {
        if (!songRepository.existsById(song.getSongId())){
            return "Song with id " + song.getSongId() + " is not present.";
        }
        songRepository.save(song);
        return "Song with id " + song.getSongId() + " gets deleted.";
    }

    public List<Song> findAllById(List<Long> songs) {
        return songRepository.findAllById(songs);
    }

    public Song getSong(Long songId) {
        return songRepository.getById(songId);
    }
}
