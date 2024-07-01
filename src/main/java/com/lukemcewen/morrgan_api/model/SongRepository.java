package com.lukemcewen.morrgan_api.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Integer> {
    
    Song findByTitle(String title);

    List<Song> findByArtist(String artist);
}
