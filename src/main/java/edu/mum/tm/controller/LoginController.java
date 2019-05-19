package edu.mum.tm.controller;

import edu.mum.tm.domain.Role;
import edu.mum.tm.domain.User;
import edu.mum.tm.service.RoleService;
import edu.mum.tm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String index() {

        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        System.out.println("Login.....");
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        System.out.println("loginError.....");
        model.addAttribute("loginError", true);
        return "login";
    }



}

