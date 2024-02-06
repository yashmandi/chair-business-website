package com.chair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chair.model.Cart;
import com.chair.model.CartItem;

@Service
public class CartItemServiceImpl {

    @Autowired
    private CartItemDao cartItemDao;

    public CartItemDao getCartCartItemDao() {
        return cartItemDao;
    }

    public void setCartItemDao(CartItemDao cartItemDao) {
        this.cartItemDao = cartItemDao;
    }

    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(String CartItemId) {
        cartItemDao.removeCartItem(CartItemId);
    }

    public void removeAllCartItems(Cart cart) {
        cartItemDao.removeAllCartItems(cart);
    }
}
