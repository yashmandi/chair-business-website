package com.chair.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chair.model.Cart;
import com.chair.model.CartItem;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CartItemDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCartItem(CartItem cartItem) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(cartItem);
        session.flush();
        session.close();
    }

    public void removeCartItem(String CartItemID) {
        Session session = sessionFactory.openSession();
        CartItem cartItem = (CartItem) session.get(CartItem.class, CartItemID);
        session.delete(cartItem);
        Cart cart = cartItem.getCart();
        List<CartItem> cartItems = cart.getCartItem();
        cartItems.remove(cartItem);
        session.flush();
        session.close();
    }

    public void removeAllCartItems(Cart cart) {
        List<CartItem> cartItems = cart.getCartItem();
        for (CartItem cartItem : cartItems) {
            removeCartItem(cartItem.getCartItemId());
        }
    }
}