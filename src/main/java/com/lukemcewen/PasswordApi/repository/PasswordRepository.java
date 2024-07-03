package com.lukemcewen.PasswordApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Password, Integer>{
    
    List<Password> findByService(String service);
}
