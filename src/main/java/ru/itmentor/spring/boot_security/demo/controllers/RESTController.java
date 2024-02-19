package ru.itmentor.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo
        .exception_handlers.NoSuchUserException;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    private final UserService userService;

    @Autowired
    public RESTController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            throw new NoSuchUserException(
                    "User with id = " + id + " not found!");
        }
        return user;
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            throw new NoSuchUserException(
                    "User with id = " + id + " not found!!!");
        }
        userService.deleteUser(id);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return user;
    }
}
