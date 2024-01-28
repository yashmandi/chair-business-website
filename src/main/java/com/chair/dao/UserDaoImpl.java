package com.chair.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.chair.model.User;
import com.mysql.cj.xdevapi.Session;
import com.mysql.cj.xdevapi.SessionFactory;

@Repository
public class UserDaoImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> users = session.createCriteria(User.class).list();
        System.out.println(users);
        session.close();
        return users;
    }

    public void deleteUser(String userId) {
        Session session = sessionFactory.openSession();
        User user = (User) session.get(User.class, userId);
        session.saveOrUpdate(user);
        session.flush();
        session.close();
    }

    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(user);
        session.flush();
        session.close();
    }

    public User getUserById(String userId) {
        Session session = sessionFactory.openSession();
        User user = (User) session.get(User.class, userId);
        session.close();
        return user;
    }

}