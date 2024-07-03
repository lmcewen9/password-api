package com.lukemcewen.PasswordApi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    
    @Autowired
    private PasswordRepository passwordRepository;

    public List<Password> findAll(){
        return passwordRepository.findAll();
    }

    public Optional<Password> findById(int id){
        return passwordRepository.findById(id);
    }

    public Password save(Password password){
        return passwordRepository.save(password);
    }

    public void deleteById(int id){
        passwordRepository.deleteById(id);
    }

    public List<Password> findByService(String service){
        return passwordRepository.findByService(service);
    }
}
