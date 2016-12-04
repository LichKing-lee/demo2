package com.example.web;

import com.example.model.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LichKing on 2016. 12. 3..
 */
@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping
    public String main(Model model){
        model.addAttribute("questions", questionRepository.findAll());
        return "/index";
    }
}
