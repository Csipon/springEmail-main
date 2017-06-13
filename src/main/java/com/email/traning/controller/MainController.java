package com.email.traning.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * Created by Pasha on 13.06.2017.
 */
@Controller
public class MainController {

    @GetMapping("/")
    public String main(Map<String, Object> model, Authentication authentication) {
        model.put("user", null);
        model.put("role", "ANONYMOUS");
        model.put("auth", false);
        return "main";
    }
}
