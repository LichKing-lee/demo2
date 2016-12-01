package com.example.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by LichKing on 2016. 11. 28..
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserId(String userId);
}