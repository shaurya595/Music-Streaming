package com.geekster.Music.Streaming.repositeries;

import com.geekster.Music.Streaming.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

}
