package com.lukemcewen.PasswordApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lukemcewen.PasswordApi.repository.Password;
import com.lukemcewen.PasswordApi.repository.PasswordResponse;
import com.lukemcewen.PasswordApi.repository.PasswordService;


@RestController
public class PasswordApiController implements ErrorController{

    @RequestMapping("/error")
    public String handleError(){
        return "Bad Query...";
    }

    @Autowired
    private PasswordService passwordService;

    @GetMapping("/apiv1/password")
    public ResponseEntity<PasswordResponse> findAll(){
        return ResponseEntity.ok(new PasswordResponse(passwordService.findAll()));
    }

    @GetMapping("/apiv1/password/{id}")
    public ResponseEntity<PasswordResponse> findById(@PathVariable int id){
        Password password = passwordService.findPasswordById(id);
        if (password == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new PasswordResponse(List.of(password)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/apiv1/password")
    public Password create(@RequestBody Password password){
        return passwordService.save(password);
    }

    @PutMapping("/apiv1/password")
    public Password update(@RequestBody Password password){
        return passwordService.save(password);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/apiv1/password/{id}")
    public void deleteById(@PathVariable int id){
        passwordService.deleteById(id);
    }

    @GetMapping("/apiv1/password/find/{service}")
    public ResponseEntity<PasswordResponse> findByService(@PathVariable String service){
        return ResponseEntity.ok(new PasswordResponse(passwordService.findByService(service)));
    }

}
