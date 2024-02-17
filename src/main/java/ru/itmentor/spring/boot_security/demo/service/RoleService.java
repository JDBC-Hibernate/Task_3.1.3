package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    Role addRole(Role role);
    Role getRoleByName(String name);
    Role getRoleById(Long id);
    Set<Role> getAllRoles();
}
