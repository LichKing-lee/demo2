package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by LichKing on 2016. 11. 24..
 */
@Entity
public class Question {
    @Id
    private long id;

    @Column(nullable = false, length = 20)
    private String writer;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    private String contents;

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Question{" +
                "writer='" + writer + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
