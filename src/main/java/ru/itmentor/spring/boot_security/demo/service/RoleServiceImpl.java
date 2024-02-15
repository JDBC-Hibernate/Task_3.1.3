package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.dao.RoleDao;
import ru.itmentor.spring.boot_security.demo.models.Role;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role addRole(Role role) {
        return roleDao.addRole(role);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public Set<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
