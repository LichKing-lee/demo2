package com.example.model;

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
    private String userId;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Question> questions;

    @OneToMany(mappedBy = "user")
    private List<Answer> answers;

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

    public void setQuestions(List<Question> questions) { this.questions = questions; }

    public void setAnswers(List<Answer> answers) { this.answers = answers; }

    public String getUserId() {
        return userId;
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
