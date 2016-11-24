package com.example.model;

/**
 * Created by LichKing on 2016. 11. 24..
 */
public class User {
    private Integer userNo;
    private String userId;
    private String password;
    private String name;
    private String email;

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }
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

    public Integer getUserNo() {
        return userNo;
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
