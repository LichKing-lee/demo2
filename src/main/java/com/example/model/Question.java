package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by LichKing on 2016. 11. 24..
 */
@Entity
public class Question {
    @Id
    @GeneratedValue
    @JsonProperty
    private Long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
    private User user;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    @Lob
    private String contents;

    public void setId(Long id){this.id = id;}

    public void setUser(User user){this.user = user;}

    public void setAnswers(List<Answer> answers){this.answers = answers;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public User getUser(){
        return this.user;
    }

    public void change(Question question){
        this.title = question.title;
        this.contents = question.contents;
    }
}
