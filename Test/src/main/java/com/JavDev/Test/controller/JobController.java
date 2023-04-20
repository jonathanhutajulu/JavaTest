package com.JavDev.Test.controller;

import com.JavDev.Test.model.JobList;
import com.JavDev.Test.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobRepository jobRepository;

    @GetMapping("/api/recruitment/positions")
    public List<JobList> getAllJob(){

        return jobRepository.findAll();
    }

    @GetMapping("/api/recruitment/positions/{id}")
    public JobList getSingleJob(@PathVariable("id") Integer id){
        return jobRepository.findById(id).get();
    }

}
