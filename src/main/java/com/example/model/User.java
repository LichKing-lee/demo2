package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by LichKing on 2016. 11. 24..
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false, length = 20)
    @JsonProperty
    private String userId;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column
    private String email;

    public void setId(Long id){this.id = id;}

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public Long getId(){
        return this.id;
    }

    public void change(User user){
        if(this.isEqualsPassword(user)) {
            this.email = user.email;
            this.name = user.name;
        }
    }

    public boolean isEqualsPassword(User user){
        return this.password.equals(user.password);
    }

    public boolean isEqualsId(Long id){
        return this.id.equals(id);
    }
}
