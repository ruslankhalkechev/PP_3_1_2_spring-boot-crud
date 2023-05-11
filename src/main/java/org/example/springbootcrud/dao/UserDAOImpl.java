package org.example.springbootcrud.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.springbootcrud.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User add(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public void deleteUserById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User update(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getListOfUsers() {
        return entityManager.createQuery("FROM User user ORDER BY user.id", User.class).getResultList();
    }
}
