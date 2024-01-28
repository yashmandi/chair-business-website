package com.chair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chair.dao.UserDAO;
import com.chair.model.User;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    public void deleteUser(String userId) {
        userDao.deleteUser(userId);
    }

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public User getUserById(String userId) {
        return userDao.getUserById(userId);
    }

}
