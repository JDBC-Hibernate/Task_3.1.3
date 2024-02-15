package ru.itmentor.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String printUsers(
            Model model,
            @AuthenticationPrincipal UserDetails loadedUser) {
        System.out.println("Principal info >>> " + loadedUser.toString());
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping("/add")
    public String addUserView(@ModelAttribute("user") User user){
        if (user.getUsername().isEmpty()
                || user.getPassword().isEmpty()) {
            return null;
        }
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/update")
    public String updateUserForm(@ModelAttribute("user") User user) {
        return "update";
    }

    @PostMapping("/update")
    public String updateUserView(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete")
    public String deleteUserForm(@ModelAttribute("user") User user) {
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteUserView(@RequestParam("id") Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            userService.deleteUser(id);
        }
        return "redirect:/admin";
    }
}
