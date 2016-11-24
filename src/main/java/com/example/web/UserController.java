package com.example.web;

import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        user.setUserNo(userList.size());
        userList.add(user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String list(Model model){
        model.addAttribute("users", userList);
        return "/user/list";
    }

    @GetMapping("/users/{id}/form")
    public String modify(@PathVariable Integer id, Model model){
        model.addAttribute("user", userList.get(id));
        System.out.println(userList.get(id));
        return "/user/updateForm";
    }

    @PostMapping("/users/{id}/update")
    public String update(@PathVariable Integer id, User user, Model model){
        if(userList.get(id).getPassword().equals(user.getPassword())){
            user.setUserNo(id);
            userList.set(id, user);
        }

        model.addAttribute("users", userList);
        return "/user/list";
    }
}
