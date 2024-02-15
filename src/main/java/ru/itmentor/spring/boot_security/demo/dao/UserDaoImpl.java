package ru.itmentor.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        String hql = "delete User u where u.id = :id";
        entityManager.createQuery(hql)
                .setParameter("id", id)
                .executeUpdate();

    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserByUsername(String username) {
        String hql = "from User u where u.username = :name";
        User user;
        try {
            Query query = entityManager
                    .createQuery(hql)
                    .setParameter("name", username);
            user = (User) query.getSingleResult();
        } catch (NoResultException e) {
            throw new NoResultException("USER NOT FOUND");
        }
        return user;

    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager
                .createQuery("from User", User.class)
                .getResultList();

    }
}
