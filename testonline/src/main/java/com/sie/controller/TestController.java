package com.sie.controller;

import com.sie.domain.User;
import com.sie.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestMapper testMapper;

    @GetMapping("/test/{id}")
    public User test(@PathVariable("id") int id){

        return testMapper.test(id);
    }
}
