package com.example.web;

import com.example.model.User;
import com.example.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LichKing on 2016. 11. 24..
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/form")
    public String form(){
        return "/user/form";
    }

    @PostMapping("")
    public String create(User user){
        System.out.println("userId :: " + user);
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("")
    public String list(Model model){
        model.addAttribute("users", userRepository.findAll());

        return "/user/list";
    }

    @GetMapping("/{id}/form")
    public String modify(@PathVariable Long id, Model model){
        User user = userRepository.findOne(id);

        model.addAttribute("user", user);
        return "/user/updateForm";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id, User user, Model model){
        User user1 = userRepository.findOne(id);
        user1.change(user);
        userRepository.save(user1);

        model.addAttribute("users", userRepository.findAll());
        return "redirect:/users";
    }
}
