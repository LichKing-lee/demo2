package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by LichKing on 2016. 11. 24..
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false, length = 20)
    private String userId;

    @Column(nullable = false, length = 20)
    private String password;
    private String name;
    private String email;

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

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
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

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
