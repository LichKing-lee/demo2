package com.example.web;

import com.example.model.User;
import com.example.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    public String modify(@PathVariable String id, Model model){
        Iterable<User> userList = userRepository.findAll();
        Iterator<User> userIterator = userList.iterator();

        while(userIterator.hasNext()){
            User user = userIterator.next();
            if(user.getUserId().equals(id)){
                model.addAttribute("user", user);
                return "/user/updateForm";
            }
        }

        throw new IllegalArgumentException("id 잘못 넘어옴");
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable String id, User user, Model model){
        Iterable<User> userIterable = userRepository.findAll();
        Iterator<User> userIterator = userIterable.iterator();

        while(userIterator.hasNext()){
            User user1 = userIterator.next();
            if(user1.getUserId().equals(id) && user1.getPassword().equals(user.getPassword())){
                user1.setEmail(user.getEmail());
                user1.setName(user.getName());
                user1.setUserId(user.getUserId());
                userRepository.save(user1);
            }
        }

        model.addAttribute("users", userIterable);
        return "/user/list";
    }
}
