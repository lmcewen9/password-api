package com.lukemcewen.PasswordApi.repository;

import java.util.List;

public class PasswordResponse {
    
    private List<Password> results;

    public PasswordResponse(List<Password> results){
        this.results = results;
    }

    public List<Password> getResults(){
        return results;
    }
}
