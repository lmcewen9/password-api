package com.lukemcewen.morrgan_api.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    
    @Autowired
    private SongRepository songRepository;

    public List<Song> findAll(){
        return songRepository.findAll();
    }

    public Song findByTitle(String title){
        return songRepository.findByTitle(title);
    }

    public List<Song> findByArtist(String artist){
        return songRepository.findByArtist(artist);
    }

    public Song save(Song song){
        return songRepository.save(song);
    }

    public void deleteById(int id){
        songRepository.deleteById(id);
    }
}
