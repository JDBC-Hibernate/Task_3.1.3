package ru.itmentor.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itmentor.spring.boot_security.demo.service.UserServiceImpl;

import java.security.Principal;

@Controller
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String userPage(
            Model model,
            Principal principal) {
        System.out.println("User >>> " + principal.toString());
        model.addAttribute(
                "user",
                userService.getUserByUsername(principal.getName())
        );
        return "user";
    }

    @GetMapping("/index")
    public String indexPage() {
        return "index-user";
    }

}
