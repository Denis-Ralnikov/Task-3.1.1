package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    public void save(User user);

    public List<User> getAllUsers();

    public User findById(Long id);

    public void deleteUser(User user);

    public void editUser(User user);
}
