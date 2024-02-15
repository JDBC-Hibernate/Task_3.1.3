package ru.itmentor.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAuthList(String r) {
        String hql = "select r from Role r";
        Query query = entityManager.createQuery(hql, Role.class);
        return query.getResultList();
    }

    @Override
    public Role addRole(Role role) {
        return null;
    }

    @Override
    public Role getRoleByName(String name) {
        String hql = "from Role r where r.name = :name";
        Query query = entityManager.createQuery(hql);
        query.setParameter("name", name).executeUpdate();
        return (Role) query.getSingleResult();
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Set<Role> getAllRoles() {
        String hql = "from Role";
        List<Role> rolesList = entityManager.createQuery(hql).getResultList();
        Set<Role> rolesSet = new HashSet<>(rolesList);
        return rolesSet;

    }
}
