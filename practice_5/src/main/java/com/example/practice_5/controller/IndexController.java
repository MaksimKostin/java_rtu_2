package com.example.practice_5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping
    public String index() {
        return "index";
    }

}