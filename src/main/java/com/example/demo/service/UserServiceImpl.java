package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }
}
