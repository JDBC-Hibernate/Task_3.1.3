package ru.itmentor.spring.boot_security.demo.dao;

import ru.itmentor.spring.boot_security.demo.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {

    List<Role> getAuthList(String username);

    Role addRole(Role role);
    Role getRoleByName(String name);
    Role getRoleById(Long id);
    Set<Role> getAllRoles();


}
