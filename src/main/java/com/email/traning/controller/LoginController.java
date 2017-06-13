package com.email.traning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Pasha on 13.06.2017.
 */
@Controller
public class LoginController {
    @GetMapping(value = "/login")
    public String login(@RequestParam(value = "logout", required = false) String logout,
                        HttpServletRequest request, Model model) throws Throwable {
        if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully.");
        }else if (request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION") != null){
            throw (Throwable) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        }
        return "login";
    }
}
