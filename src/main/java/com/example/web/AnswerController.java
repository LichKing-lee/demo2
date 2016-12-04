package com.example.web;

import com.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by LichKing on 2016. 12. 3..
 */
@Controller
@RequestMapping("/question/{questionId}/answers")
public class AnswerController {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @PostMapping
    public String create(@PathVariable Long questionId, Answer answer, HttpSession session){
        User user = (User) session.getAttribute(UserController.SESSION_KEY);
        Question question = questionRepository.findOne(questionId);

        answer.setUser(user);
        answer.setQuestion(question);
        answerRepository.save(answer);
        return "redirect:/question/" + questionId;
    }
}
