package com.example.web;

import com.example.model.*;
import com.example.utils.LoginUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by LichKing on 2016. 12. 3..
 */
@RestController
@RequestMapping("/api/question/{questionId}/answers")
public class AnswerController {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @PostMapping
    public Answer create(@PathVariable Long questionId, Answer answer, HttpSession session){
        if(!LoginUtils.hasLoginUser(session.getAttribute(UserController.SESSION_KEY))){
            return null;
        }

        User user = (User) session.getAttribute(UserController.SESSION_KEY);
        Question question = questionRepository.findOne(questionId);

        answer.setUser(user);
        answer.setQuestion(question);
        return answerRepository.save(answer);
    }

    @GetMapping("/{id}/form")
    public String modify(@PathVariable Long questionId, @PathVariable Long id, Model model, HttpSession session){
        Answer answer = answerRepository.findOne(id);

        if(!LoginUtils.isValidLoginUser(session.getAttribute(UserController.SESSION_KEY), answer.getUser().getId())){
            return QuestionController.REDIRECT_QUESTION + questionId;
        }

        model.addAttribute("question", questionRepository.findOne(questionId));
        model.addAttribute("answer", answer);

        return "/qna/updateShow";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long questionId, @PathVariable Long id, Answer answer, HttpSession session){
        Answer dbAnswer = answerRepository.findOne(id);

        if(!LoginUtils.isValidLoginUser(session.getAttribute(UserController.SESSION_KEY), dbAnswer.getUser().getId())){
            return QuestionController.REDIRECT_QUESTION + questionId;
        }

        dbAnswer.change(answer);
        answerRepository.save(dbAnswer);

        return QuestionController.REDIRECT_QUESTION + questionId;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long questionId, @PathVariable Long id, HttpSession session){
        Answer answer = answerRepository.findOne(id);

        if(!LoginUtils.isValidLoginUser(session.getAttribute(UserController.SESSION_KEY), answer.getUser().getId())){
            return Result.fail("Unvalid User");
        }

        answerRepository.delete(id);

        return Result.ok();
    }
}
