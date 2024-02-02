package com.chair.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.cj.xdevapi.SessionFactory;

import jakarta.transaction.Transactional;
import jakarta.websocket.Session;

@Repository
@Transactional
public class CustomerOrderDaoImpl {
    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
        session.close();
    }

}
