package com.example.web;

import com.example.model.QuestionRepository;
import com.example.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by LichKing on 2016. 12. 3..
 */
@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String main(Model model, HttpSession session){
        session.setAttribute("loginUser", userRepository.findByUserId("lcy1111"));
        model.addAttribute("questions", questionRepository.findAll());
        return "/index";
    }
}
