package com.chair.dao;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Repository;

import com.chair.model.Cart;
import com.chair.service.CustomerOrderService;
import com.mysql.cj.xdevapi.SessionFactory;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CartDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CustomerOrderService customerOrderService;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Cart getCartByCartId(String cartId) {
        Session session = sessionFactory.openSession();
        Cart cart = session.get(Cart.class, cartId);
        System.out.println(cart);
        session.close();
        return cart;
    }

    public Cart validateCart(String cartId) {
        Cart cart = getCartByCartId(cartId);
        if (cart == null || cart.getCartItem().size() == 0) {
            throw new IOException(cartId + "");
        }
        update(cart);
        return cart;
    }

    public void update(Cart cart) {
        String cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setTotalPrice(grandTotal);

        Session session = sessionFactory.openSession();
        session.saveOrUpdate(cart);
        session.flush();
        session.close();
    }

}
