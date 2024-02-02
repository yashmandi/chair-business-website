package com.chair.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chair.model.Product;
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;

import jakarta.transaction.Transactional;

@Repository(value = "productDao")
public class ProductDaoImpl {
    // this class is wired with the SessionFactory to do some
    // database operations

    @Autowired
    private SessionFactory sessionFactory;

    // this will create one sessionFactory for this class
    // there is only one sessionFactory in the application
    // we can create multiple sessionFactories
    // each session can do some database operations

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Product> getAllProducts() {
        // reading the records from table
        Session session = sessionFactory.openSession();
        List<Product> products = session.createCriteria(Product.class).list();
        System.out.println("--------List of Products---------");
        System.out.println(products);
        // session.flush is used to clear the cache in the session
        session.flush();
        session.close();
        return products;
    }

    public Product getProductById(String productId) {
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class, productId);
        session.flush();
        session.close();
        return product;
    }

    public void deleteProduct(String productId) {
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class, productId);
        session.delete(product);
        session.flush();
        session.close();
    }

    public void addProduct(Product product) {
        Session session = sessionFactory.openSession();
        session.save(product);
        session.flush();
        session.close();
    }

    public void editProduct(Product product) {
        Session session = sessionFactory.openSession();
        session.update(product);
        session.flush();
        session.close();
    }
}
