package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by LichKing on 2016. 12. 3..
 */
@Entity
public class Answer {
    @Id
    @GeneratedValue
    @JsonProperty
    private Long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_question"))
    @JsonProperty
    private Question question;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
    @JsonProperty
    private User user;

    @Column(nullable = false)
    @Lob
    @JsonProperty
    private String contents;

    @Column(nullable = false)
    private boolean deleted;

    public void setId(Long id){
        this.id = id;
    }

    public void setQuestion(Question question){
        this.question = question;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setContents(String contents){
        this.contents = contents;
    }

    public User getUser(){
        return this.user;
    }

    public void change(Answer answer){
        this.contents = answer.contents;
    }

    public void delete(){
        this.deleted = true;
    }
}
