package com.chair.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties.Listener.Session;
import org.springframework.stereotype.Repository;
import com.chair.dao.CustomerDAO;
import com.chair.model.Authorities;
import com.chair.model.Cart;
import com.chair.model.Customer;
import com.chair.model.User;
import com.mysql.cj.xdevapi.SessionFactory;

import jakarta.persistence.Query;

@Repository
public class CustomerDaoImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCustomer(Customer customer) {
        System.out.println("Adding Customer in DAO");
        Session session = sessionFactory.openSession();
        customer.getUser().setEnabled(true);

        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmailId(customer.getUser().getEmailId);

        Cart cart = new Cart();
        // it is to set CartId for customer table
        customer.setCart(cart);
        // if we omit this statement, hen it will insert null for customerid in cart
        // to set the customerid in cart table
        cart.setCustomer(customer);
        session.save(customer);
        session.save(authorities);
        session.flush;
        session.close;
    }

    public List<Customer> getAllCustomers() {
        Session session = sessionFactory.openSession();
        List<Customer> customerList = session.createQuery("from Customer").list();

        return customerList;
    }

    public Customer getCustomerByemailId(String emailId) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User where emailId = ?");
        query.setString(0, emailId);
        User user = (User) query.uniqueResult();
        Customer customer = user.getCustomer();
        return customer;
    }

}
