package com.example.model;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by LichKing on 2016. 12. 3..
 */
@Entity
public class Answer {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_question"))
    private Question question;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
    private User user;

    @Column(nullable = false)
    @Lob
    private String contents;

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

    public void change(Answer answer){
        this.contents = answer.contents;
    }
}
