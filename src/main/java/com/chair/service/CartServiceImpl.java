package com.chair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chair.dao.CartDAO;
import com.chair.model.Cart;

@Service
public class CartServiceImpl {
    @Autowired
    private CartDAO cartDAO;

    public CartDAO getCartDAO() {
        return cartDAO;
    }

    public void setCartDAO(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    public Cart getCartByCartId(String cartId) {
        return cartDAO.getCartByCartId(cartId);
    }
}
