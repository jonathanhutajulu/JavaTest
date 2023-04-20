package com.JavDev.Test.repository;

import com.JavDev.Test.model.JobList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobList, Integer> {
}
