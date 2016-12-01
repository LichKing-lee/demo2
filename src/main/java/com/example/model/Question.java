package com.example.model;

import javax.persistence.*;

/**
 * Created by LichKing on 2016. 11. 24..
 */
@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
    private User user;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    private String contents;

    public void setId(Long id){this.id = id;}

    public void setUser(User user){this.user = user;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Question{" +
                "user='" + user + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
