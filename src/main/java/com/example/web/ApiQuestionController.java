package com.example.web;

import com.example.model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by LichKing on 2016. 12. 5..
 */
@RestController
@RequestMapping("/api/question")
public class ApiQuestionController {
    @GetMapping("/questions")
    public List<Question> getQuestions(){
        return null;
    }
}
