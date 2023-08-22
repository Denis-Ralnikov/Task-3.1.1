package com.example.demo.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(User user) {
    entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT e FROM User e", User.class).getResultList();
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }


}
