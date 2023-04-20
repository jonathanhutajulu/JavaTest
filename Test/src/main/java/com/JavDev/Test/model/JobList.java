package com.JavDev.Test.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "job_list")
public class JobList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer job_id;

    @Column(nullable = false, unique = true)
    private String position;

    @Column(nullable = false)
    private String job_desc;

    @Column(nullable = false)
    private String minimum_qlts;

    private Timestamp opening_until;

    public JobList(){

    }

    public JobList(String position, String job_desc, String minimum_qlts) {
        this.position = position;
        this.job_desc = job_desc;
        this.minimum_qlts = minimum_qlts;
    }



    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJob_desc() {
        return job_desc;
    }

    public void setJob_desc(String job_desc) {
        this.job_desc = job_desc;
    }

    public String getMinimum_qlts() {
        return minimum_qlts;
    }

    public void setMinimum_qlts(String minimum_qlts) {
        this.minimum_qlts = minimum_qlts;
    }

    public Timestamp getOpening_until() {
        return opening_until;
    }

    public void setOpening_until(Timestamp opening_until) {
        this.opening_until = opening_until;
    }
}
