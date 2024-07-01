package com.lukemcewen.morrgan_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class MorrganApiController {

    @GetMapping("/")    
    public String getHello(){
        return "Hello World";
    }
}
