package com.java.task.java_grade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/home")
    public String goHome(){
        return "home";
    }
}