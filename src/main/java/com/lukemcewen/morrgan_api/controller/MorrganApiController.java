package com.lukemcewen.morrgan_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukemcewen.morrgan_api.model.Song;
import com.lukemcewen.morrgan_api.model.SongService;


@RestController
@RequestMapping("/")
public class MorrganApiController {

    @Autowired
    private SongService songService;

    @GetMapping
    public String random(){
        return "Fuck you!";
    }

    @GetMapping("/song")    
    public List<Song> findAll(){
        return songService.findAll();
    }

    @GetMapping("/song/title/{field}")
    public Song findByTitle(@PathVariable String field){
        return songService.findByTitle(field);
    }

    @GetMapping("/song/artist/{field}")
    public List<Song> findByArtist(@PathVariable String artist){
        return songService.findByArtist(artist);
    }
}
