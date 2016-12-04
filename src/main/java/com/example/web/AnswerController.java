package com.example.web;

import com.example.model.*;
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

    @GetMapping("/{id}/form")
    public String modify(@PathVariable Long questionId, @PathVariable Long id, Model model){
        Answer answer = answerRepository.findOne(id);
        model.addAttribute("question", questionRepository.findOne(questionId));
        model.addAttribute("answer", answer);

        return "/qna/updateShow";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long questionId, @PathVariable Long id, Answer answer){
        Answer dbAnswer = answerRepository.findOne(id);
        dbAnswer.change(answer);
        answerRepository.save(dbAnswer);

        return "redirect:/question/" + questionId;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long questionId, @PathVariable Long id){
        answerRepository.delete(id);

        return "redirect:/question/" + questionId;
    }
}
