package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.dao.UserDao;
import ru.itmentor.spring.boot_security.demo.models.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDao;

    public UserDetailsServiceImpl() {
    }

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDetails loadedUser;
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("[!] USER NOT FOUND!!!");
        }
        loadedUser = new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        user.getAuthorities()
                );
        return loadedUser;

    }

}
