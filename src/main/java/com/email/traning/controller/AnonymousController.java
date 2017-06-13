package com.email.traning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pasha on 13.06.2017.
 */
@Controller
@RequestMapping("ANONYMOUS")
public class AnonymousController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
