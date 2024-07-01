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

    @GetMapping("{table}/")    
    public List<Song> findAll(@PathVariable String table){
        return songService.findAll();
    }

    @GetMapping("{table}/{field}")
    public Song findByTitle(@PathVariable String table, @PathVariable String field){
        return songService.findByTitle(field);
    }
}
