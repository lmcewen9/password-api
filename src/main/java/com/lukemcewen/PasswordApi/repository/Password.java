package com.lukemcewen.PasswordApi.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Password{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String service;
    private String username;
    private String email;
    private String password;

    public int getId(){
        return id;
    }

    public String getService(){
        return service;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public void setService(String service){
        this.service = service;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Password(){}

    public Password(String service, String username, String email, String password){
        this.service = service;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}