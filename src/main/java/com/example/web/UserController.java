package com.example.web;

import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LichKing on 2016. 11. 24..
 */
@Controller
public class UserController {
    private List<User> userList = new ArrayList<>();

    @PostMapping("/user/create")
    public String create(User user){
        System.out.println("userId :: " + user);
        userList.add(user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String list(Model model){
        model.addAttribute("users", userList);
        return "/user/list";
    }
}
