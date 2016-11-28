package com.example.web;

import com.example.model.Qna;
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
public class QnaController {
    private List<Qna> qnaList = new ArrayList<>();

    @GetMapping("/qna/form")
    public String form(){
        return "/qna/form";
    }

    @PostMapping("/qna/create")
    public String create(Qna qna){
        qnaList.add(qna);
        return "redirect:/";
    }

    @GetMapping("/")
    public String qnas(Model model){
        model.addAttribute("qnas", qnaList);
        return "/index";
    }
}
