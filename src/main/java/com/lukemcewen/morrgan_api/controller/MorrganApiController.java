package com.lukemcewen.morrgan_api.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.annotation.WebServlet;

@RestController
@WebServlet("/api")
public class MorrganApiController {
    
    public String getHello(){
        return "Hello World";
    }
}
