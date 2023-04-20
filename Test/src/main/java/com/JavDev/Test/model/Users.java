package com.JavDev.Test.model;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Users(){

    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreate_at() {
        return created_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.created_at = create_at;
    }

    public Timestamp getUpdate_at() {
        return updated_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.updated_at = update_at;
    }
}
