package com.example.web;

import com.example.model.Question;
import com.example.model.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LichKing on 2016. 11. 24..
 */
@Controller
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/question/form")
    public String form(){
        return "/qna/form";
    }

    @PostMapping("/question/create")
    public String create(Question question){
        questionRepository.save(question);
        return "redirect:/";
    }

    @GetMapping("/")
    public String questions(Model model){
        model.addAttribute("questions", questionRepository.findAll());
        return "/index";
    }
}
