package com.sie.controller;

import com.sie.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class t {
    @PostMapping("/test")
    public User test(User user){
        System.out.println(user.getIdentity());
        return user;
    }

}
