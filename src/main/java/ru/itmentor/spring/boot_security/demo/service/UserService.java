package ru.itmentor.spring.boot_security.demo.service;

import ru.itmentor.spring.boot_security.demo.models.User;
import java.util.List;

public interface UserService {

    User getUserById(Long id);

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    User getUserByUsername(String username);

}
