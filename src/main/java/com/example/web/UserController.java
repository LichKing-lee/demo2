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
@Controller("/users")
public class UserController {
    private List<User> userList = new ArrayList<>();

    @GetMapping("/form")
    public String form(){
        return "/user/form";
    }

    @PostMapping("")
    public String create(User user){
        System.out.println("userId :: " + user);
        userList.add(user);
        return "redirect:/users";
    }

    @GetMapping("")
    public String list(Model model){
        model.addAttribute("users", userList);

        return "/user/list";
    }

    @GetMapping("/{id}/form")
    public String modify(@PathVariable String id, Model model){
        for(User user : userList){
            if(user.getUserId().equals(id)){
                model.addAttribute("user", user);
                return "/user/updateForm";
            }
        }

        throw new IllegalArgumentException("id 잘못 넘어옴");
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable String id, User user, Model model){
        for(User user1 : userList){
            if(user1.getUserId().equals(id) && user1.getPassword().equals(user.getPassword())){
                user1.setEmail(user.getEmail());
                user1.setName(user.getName());
                user1.setUserId(user.getUserId());
            }
        }

        model.addAttribute("users", userList);
        return "/user/list";
    }
}
