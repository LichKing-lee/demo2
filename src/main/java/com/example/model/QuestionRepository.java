package com.example.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by LichKing on 2016. 11. 28..
 */
public interface QuestionRepository extends CrudRepository<Question, Long>{
    List<Question> findByDeletedOrderByIdDesc(boolean deleted);
}
