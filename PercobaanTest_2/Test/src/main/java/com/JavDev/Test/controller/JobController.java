package com.JavDev.Test.controller;

import com.JavDev.Test.model.Users;
import com.JavDev.Test.repository.JobRepository;
import com.JavDev.Test.repository.UserRepository;
import com.JavDev.Test.sevice.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class JobController {

    @Autowired
    UserRepository userRepository;

    AuthController authController;

    @Autowired
    JobRepository jobRepository;

    AuthService authService = new AuthService();

    public JobController(){

    }


    @GetMapping("/api/recruitment/positions")
    public ResponseEntity<?>  getAllJob(@RequestBody Map<String, String> body){

        String token = body.get("token");

        if(token == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Anda Belum Login");
        }

        String nama = authService.getUsernameFromToken(token);
        Users user = userRepository.findByUsername(nama);

        if(user == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Hey kamu user mana -_-");
        }

        return ResponseEntity.ok(jobRepository.findAll());
    }

    @GetMapping("/api/recruitment/positions/{id}")
    public ResponseEntity<?> getSingleJob(@PathVariable("id") Integer id, @RequestBody Map<String, String> body){


        String token = body.get("token");

        if(token == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Anda Belum Login");
        }

        String nama = authService.getUsernameFromToken(token);

        Users user = userRepository.findByUsername(nama);

        if(user == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Anda Belum Login");
        }

        if(jobRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tidak ada pekerjaan untuk posisi itu");
        }

        return ResponseEntity.ok(jobRepository.findById(id).get());

    }

}
