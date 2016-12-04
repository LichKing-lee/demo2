package com.example.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by LichKing on 2016. 12. 3..
 */
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    List<Answer> findByQuestionId(Long id);
}
