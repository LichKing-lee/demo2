package com.example.web;

import com.example.model.*;
import com.example.utils.LoginUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by LichKing on 2016. 12. 3..
 */
@Controller
@RequestMapping("/question/{questionId}/answers")
public class AnswerController {
    private static final String QUESTION_PREFIX = "redirect:/question/";
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @PostMapping
    public String create(@PathVariable Long questionId, Answer answer, HttpSession session){
        if(!LoginUtils.hasLoginUser(session.getAttribute(UserController.SESSION_KEY))){
            return QUESTION_PREFIX + questionId;
        }

        User user = (User) session.getAttribute(UserController.SESSION_KEY);
        Question question = questionRepository.findOne(questionId);

        answer.setUser(user);
        answer.setQuestion(question);
        answerRepository.save(answer);
        return QUESTION_PREFIX + questionId;
    }

    @GetMapping("/{id}/form")
    public String modify(@PathVariable Long questionId, @PathVariable Long id, Model model, HttpSession session){
        Answer answer = answerRepository.findOne(id);

        if(!LoginUtils.isValidLoginUser(session.getAttribute(UserController.SESSION_KEY), answer.getUser().getId())){
            return QUESTION_PREFIX + questionId;
        }

        model.addAttribute("question", questionRepository.findOne(questionId));
        model.addAttribute("answer", answer);

        return "/qna/updateShow";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long questionId, @PathVariable Long id, Answer answer, HttpSession session){
        Answer dbAnswer = answerRepository.findOne(id);

        if(!LoginUtils.isValidLoginUser(session.getAttribute(UserController.SESSION_KEY), dbAnswer.getUser().getId())){
            return QUESTION_PREFIX + questionId;
        }

        dbAnswer.change(answer);
        answerRepository.save(dbAnswer);

        return QUESTION_PREFIX + questionId;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long questionId, @PathVariable Long id, HttpSession session){
        Answer answer = answerRepository.findOne(id);
        if(!LoginUtils.isValidLoginUser(session.getAttribute(UserController.SESSION_KEY), answer.getUser().getId())){
            return QUESTION_PREFIX + questionId;
        }

        answerRepository.delete(id);

        return QUESTION_PREFIX + questionId;
    }
}
