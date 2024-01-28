package com.chair.dao;

import java.util.List;

import com.chair.model.User;

public interface UserDAO {

    List<User> getAllUsers();

    void deleteUser(String userId);

    void addUser(User user);

    User getUserById(String userId);

}
