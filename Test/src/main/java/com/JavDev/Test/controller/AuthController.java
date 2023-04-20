package com.JavDev.Test.controller;

import com.JavDev.Test.model.Users;
import com.JavDev.Test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body){
        String username = body.get("username");
        String password = body.get("password");


        Users user = userRepository.findByUsername(username);

        if(user == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("username anda salah bro");
        }

        if (user.getUsername() != null && Objects.equals(password, user.getPassword())){
            return ResponseEntity.ok().body("Anda berhasil login");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username atau Password salah");

    }



}
