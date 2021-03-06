package com.example.web;

import com.example.model.*;
import com.example.utils.LoginUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LichKing on 2016. 11. 24..
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
    public static final String REDIRECT_QUESTION = "redirect:/question/";
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("/form")
    public String form(HttpSession session){
        if(!LoginUtils.hasLoginUser(session.getAttribute(UserController.SESSION_KEY))){
            return "redirect:/users/login";
        }

        return "/qna/form";
    }

    @PostMapping("/create")
    public String create(Question question, HttpSession session){
        question.setUser((User) session.getAttribute(UserController.SESSION_KEY));
        questionRepository.save(question);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model){
        model.addAttribute("question", questionRepository.findOne(id));

        return "/qna/show";
    }

    @GetMapping("/{id}/form")
    public String modify(@PathVariable Long id, Model model, HttpSession session){
        Question question = questionRepository.findOne(id);
        if(!LoginUtils.isValidLoginUser(session.getAttribute(UserController.SESSION_KEY), question.getUser().getId())){
            return REDIRECT_QUESTION + id;
        }

        model.addAttribute("question", question);

        return "/qna/updateForm";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, Question question, HttpSession session){
        Question dbQuestion = questionRepository.findOne(id);

        if(!LoginUtils.isValidLoginUser(session.getAttribute(UserController.SESSION_KEY), dbQuestion.getUser().getId())){
            return REDIRECT_QUESTION + id;
        }

        dbQuestion.change(question);
        questionRepository.save(dbQuestion);

        return "redirect:/question/" + id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, HttpSession session){
        Question question = questionRepository.findOne(id);
        if(!LoginUtils.isValidLoginUser(session.getAttribute(UserController.SESSION_KEY), question.getUser().getId())){
            return REDIRECT_QUESTION + id;
        }

        List<Answer> answers = answerRepository.findByQuestionId(id);
        answerRepository.delete(answers);
        questionRepository.delete(id);

        return "redirect:/";
    }
}
